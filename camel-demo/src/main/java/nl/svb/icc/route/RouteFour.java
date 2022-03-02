package nl.svb.icc.route;

import nl.svb.icc.message.employee.Employee;
import nl.svb.icc.message.worker.Worker;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class RouteFour extends RouteBuilder {

    @Override
    public void configure() {
        from("file://C:\\messages\\CamelTest4\\in")
                .to("log:nl.svb.icc.demo.BeforeUnmarshal?showAll=true")
                .unmarshal().json(JsonLibrary.Jackson, Worker.class)
                .to("log:nl.svb.icc.demo.AfterUnmarshal?showAll=true")
                .process("WorkerToEmployeeProcessor")
                .to("log:nl.svb.icc.demo.BeforeMarshal?showAll=true")
                .marshal().json(JsonLibrary.Jackson, Employee.class)
                .to("log:nl.svb.icc.demo.AfterMarshal?showAll=true")
                .to("file://C:\\messages\\CamelTest4\\out")
        ;
    }

}
