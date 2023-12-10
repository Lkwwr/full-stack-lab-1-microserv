package kz.lkwwr.centerservice.services;

import kz.lkwwr.centerservice.entities.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployee(Long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    List<Employee> getEmployeesByCenterId(Long id);
}
