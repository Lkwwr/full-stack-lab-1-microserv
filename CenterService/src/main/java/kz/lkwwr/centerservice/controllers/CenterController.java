package kz.lkwwr.centerservice.controllers;

import kz.lkwwr.centerservice.dtos.CenterDTO;
import kz.lkwwr.centerservice.entities.Center;
import kz.lkwwr.centerservice.entities.Employee;
import kz.lkwwr.centerservice.services.CenterService;
import kz.lkwwr.centerservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CenterController {
    @Autowired
    private CenterService centerService;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/centers")
    public List<Center> getCenters() {
        return centerService.getAllCenters();
    }

    @PostMapping("/add-center")
    public ResponseEntity<Center> addCenter(@RequestBody Center center) {
        centerService.addCenter(center);
        return new ResponseEntity<>(center, HttpStatus.CREATED);
    }

    @GetMapping("/center/{id}")
    public CenterDTO getCenter(@PathVariable(name = "id") Long id) {
        Center center = centerService.getCenter(id);
        return centerService.convertToDTO(center);
    }

    @GetMapping("/center/{id}/employees")
    public Set<Employee> getEmployeesByCenter(@PathVariable(name = "id") Long id) {
        return employeeService.getEmployeesByCenterId(id);
    }

    @PostMapping("/save-center")
    public ResponseEntity<Center> saveCenter(@RequestBody Center center) {
        centerService.saveCenter(center);
        return new ResponseEntity<>(center, HttpStatus.OK);
    }

    @PostMapping("/delete-center")
    public void deleteCenter(@RequestParam(name = "id") Long id) {
        Center center = centerService.getCenter(id);
        centerService.deleteCenter(center);
    }
}
