package kz.lkwwr.centerservice.controllers;

import kz.lkwwr.centerservice.dtos.EmployeeDto;
import kz.lkwwr.centerservice.entities.Employee;
import kz.lkwwr.centerservice.services.CenterService;
import kz.lkwwr.centerservice.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CenterService centerService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable(name = "id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        EmployeeDto employeeDto = employee.toDTO();
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @DeleteMapping("/admin/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(name = "id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/admin/add-employee")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeDto.toEntity();
        if (employee.getCenter() == null) employee.setCenter(centerService.getCenter(employeeDto.getCenterId()));
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @PostMapping("/admin/save-employee")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeDto.toEntity();
        if (employee.getCenter() == null) employee.setCenter(centerService.getCenter(employeeDto.getCenterId()));
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
