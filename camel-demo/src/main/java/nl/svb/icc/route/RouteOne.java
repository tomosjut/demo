package nl.svb.icc.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class RouteOne extends RouteBuilder {

    @Override
    public void configure() {
        from("file://C:\\messages\\CamelTest1\\in")
                .log("Body: ${body}")
                .to("file://C:\\messages\\CamelTest1\\out")
        ;
    }

}
