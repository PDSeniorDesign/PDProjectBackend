package sbrest.model.dao;

import java.util.List;

import sbrest.model.Employee;

public interface EmployeeDao {

    Employee getEmployee(Integer id);

    List<Employee> getEmployees();

    Employee saveEmployee(Employee employee);
    
    void deleteEmployee(Integer id);
}