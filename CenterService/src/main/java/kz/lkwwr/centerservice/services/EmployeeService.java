package kz.lkwwr.centerservice.services;


import kz.lkwwr.centerservice.dtos.EmployeeDTO;
import kz.lkwwr.centerservice.entities.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployee(Long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    EmployeeDTO convertToDTO(Employee employee);

    Set<Employee> getEmployeesByCenterId(Long id);
}
