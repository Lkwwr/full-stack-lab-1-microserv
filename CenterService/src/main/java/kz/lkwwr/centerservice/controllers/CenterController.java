package kz.lkwwr.centerservice.controllers;

import kz.lkwwr.centerservice.entities.Center;
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
public class CenterController {
    private final CenterService centerService;
    private final EmployeeService employeeService;

    @GetMapping("/centers")
    public ResponseEntity<List<Center>> getCenters() {
        List<Center> centers = centerService.getCenters();
        return new ResponseEntity<>(centers, HttpStatus.OK);
    }

    @PostMapping("/add-center")
    public ResponseEntity<Center> addCenter(@RequestBody Center center) {
        centerService.addCenter(center);
        return new ResponseEntity<>(center, HttpStatus.CREATED);
    }

    @GetMapping("/center/{id}")
    public ResponseEntity<Center> getCenter(@PathVariable(name = "id") Long id) {
        Center center = centerService.getCenter(id);
        return new ResponseEntity<>(center, HttpStatus.OK);
    }

    @DeleteMapping("/center/{id}")
    public ResponseEntity<Void> deleteCenter(@PathVariable(name = "id") Long id) {
        Center center = centerService.getCenter(id);
        centerService.deleteCenter(center);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/center/{id}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByCenter(@PathVariable(name = "id") Long id) {
        List<Employee> employees = employeeService.getEmployeesByCenterId(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/update-center")
    public ResponseEntity<Center> updateCenter(@RequestBody Center center) {
        centerService.saveCenter(center);
        return new ResponseEntity<>(center, HttpStatus.OK);
    }
}
