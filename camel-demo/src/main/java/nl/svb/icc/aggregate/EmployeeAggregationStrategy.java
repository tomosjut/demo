package nl.svb.icc.aggregate;

import nl.svb.icc.message.employee.Employee;
import nl.svb.icc.message.employee.Employees;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAggregationStrategy implements AggregationStrategy {
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        int id =0;
        if(oldExchange == null){
            Employees employees = new Employees();
            List<Employee> employeeList = new ArrayList<Employee>();
            Employee employee = newExchange.getIn().getBody(Employee.class);

            employeeList.add(employee);
            employees.setEmployees(employeeList);
            id++;
            newExchange.getIn().setHeader("ID", id);
            newExchange.getIn().setBody(employees);
            return newExchange;
        } else {
            Employees employees = oldExchange.getIn().getBody(Employees.class);
            Employee employee = newExchange.getIn().getBody(Employee.class);
            employees.getEmployees().add(employee);
            oldExchange.getIn().setHeader("ID", id);
            oldExchange.getIn().setBody(employees);
            return oldExchange;
        }
    }
}
