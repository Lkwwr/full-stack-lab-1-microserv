package kz.lkwwr.centerservice.controllers;

import kz.lkwwr.centerservice.dtos.CarDTO;
import kz.lkwwr.centerservice.entities.Car;
import kz.lkwwr.centerservice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add-car")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @GetMapping("/car/{id}")
    public CarDTO getCar(@PathVariable(name = "id") Long id) {
        Car car = carService.getCar(id);
        return carService.convertToDTO(car);
    }

    @PostMapping("/save-car")
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        carService.saveCar(car);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/delete-car")
    public void deleteCar(@RequestParam(name = "id") Long id) {
        Car car = carService.getCar(id);
        carService.deleteCar(car);
    }
}