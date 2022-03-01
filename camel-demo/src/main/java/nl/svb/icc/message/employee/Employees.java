package nl.svb.icc.message.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "employees"
})
public class Employees {

    @JsonProperty("employees")
    private List<Employee> employees;

    @JsonProperty("employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @JsonProperty("employees")
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
