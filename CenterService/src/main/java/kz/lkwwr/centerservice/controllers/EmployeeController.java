package kz.lkwwr.centerservice.controllers;

import kz.lkwwr.centerservice.dtos.EmployeeDTO;
import kz.lkwwr.centerservice.entities.Employee;
import kz.lkwwr.centerservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable(name = "id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        return employeeService.convertToDTO(employee);
    }

    @PostMapping("/save-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/delete-employee")
    public void deleteEmployee(@RequestParam(name = "id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(employee);
    }
}
