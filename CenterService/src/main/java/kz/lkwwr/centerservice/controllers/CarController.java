package kz.lkwwr.centerservice.controllers;

import kz.lkwwr.centerservice.entities.Car;
import kz.lkwwr.centerservice.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @GetMapping("/admin")
    public String admin(){
        return "Admin";
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = carService.getCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping("/add-car")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCar(@PathVariable(name = "id") Long id) {
        Car car = carService.getCar(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable(name = "id") Long id) {
        Car car = carService.getCar(id);
        carService.deleteCar(car);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/save-car")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        carService.saveCar(car);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
}