package nl.svb.icc.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class RouteThree extends RouteBuilder {

    @Override
    public void configure() {
        from("file://C:\\messages\\CamelTest3\\in")
                .log("Body: ${body}")
                .split(xpath("/Apples/Apple"))
                    .setHeader("AppleName", xpath("/Apple/Name").resultType(String.class))
                    .log("Body: ${body}")
                    .to("file://C:\\messages\\CamelTest3\\out?fileName=${in.header.AppleName}.xml")
                .end()
        ;
    }

}
