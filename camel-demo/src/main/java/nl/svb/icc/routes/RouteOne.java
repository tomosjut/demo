package nl.svb.icc.routes;

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
public class RouteOne extends RouteBuilder {

    @Override
    public void configure() {
    }

}
