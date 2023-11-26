package kz.lkwwr.centerservice.controllers;

import kz.lkwwr.centerservice.dtos.HomeDTO;
import kz.lkwwr.centerservice.services.CarService;
import kz.lkwwr.centerservice.services.CenterService;
import kz.lkwwr.centerservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private CarService carService;
    @Autowired
    private CenterService centerService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public HomeDTO getHome() {
        HomeDTO homeDTO = new HomeDTO();

        homeDTO.setCars(carService.getAllCars());
        homeDTO.setCenters(centerService.getAllCenters());
        homeDTO.setEmployees(employeeService.getAllEmployees());

        return homeDTO;
    }
}