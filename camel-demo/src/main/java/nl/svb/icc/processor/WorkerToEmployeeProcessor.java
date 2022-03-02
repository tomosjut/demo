package nl.svb.icc.processor;

import nl.svb.icc.message.employee.Address;
import nl.svb.icc.message.employee.Employee;
import nl.svb.icc.message.employee.Name;
import nl.svb.icc.message.worker.Worker;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("WorkerToEmployeeProcessor")
public class WorkerToEmployeeProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        Worker worker = exchange.getIn().getBody(Worker.class);

        Employee employee = new Employee();

        employee.setEmployeeID(worker.getWorkerID());

        Name name = new Name();
        String[] workerName = worker.getName().split(" ");
        name.setFirstName(workerName[0]);
        name.setLastName(workerName[1]);
        employee.setName(name);

        Address address = new Address();
        String[] workerAddress = worker.getAddress().split(" ");
        address.setStreet(workerAddress[0]);
        address.setHouseNumber(workerAddress[1]);
        employee.setAddress(address);

        exchange.getIn().setBody(employee);
    }
}
