package nl.svb.icc.route;

import nl.svb.icc.processor.MyProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class RouteTwo extends RouteBuilder {

    @Override
    public void configure() {
        from("file://C:\\messages\\CamelTest2\\in")
                .log("Body: ${body}")
                .process("MyProcessor")
                .log("Body: ${body}")
                .to("file://C:\\messages\\CamelTest2\\out")
        ;
    }

}
