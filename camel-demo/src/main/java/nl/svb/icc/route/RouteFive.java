package nl.svb.icc.route;

import nl.svb.icc.aggregate.EmployeeAggregationStrategy;
import nl.svb.icc.message.employee.Employee;
import nl.svb.icc.message.employee.Employees;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class RouteFive extends RouteBuilder {

    @Override
    public void configure() {
        from("file://C:\\messages\\CamelTest5\\in")
                .unmarshal().json(JsonLibrary.Jackson, Employee.class)
                .aggregate(constant("true"), new EmployeeAggregationStrategy()).completionSize(5).completionTimeout(10000)
                .marshal().json(JsonLibrary.Jackson, Employees.class)
                .to("file://C:\\messages\\CamelTest5\\out?fileName=Batch_${in.header.ID}.json")
        ;
    }

}
