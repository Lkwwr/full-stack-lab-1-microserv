package kz.lkwwr.centerservice.controllers;

import kz.lkwwr.centerservice.dtos.CarDto;
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

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = carService.getCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping("/admin/add-car")
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto) {
        Car car = carDto.toEntity();
        carService.addCar(car);
        return new ResponseEntity<>(carDto, HttpStatus.CREATED);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable(name = "id") Long id) {
        Car car = carService.getCar(id);
        CarDto carDto = car.toDTO();
        return new ResponseEntity<>(carDto, HttpStatus.OK);
    }

    @DeleteMapping("/admin/car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable(name = "id") Long id) {
        Car car = carService.getCar(id);
        carService.deleteCar(car);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/admin/save-car")
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto carDto) {
        Car car = carDto.toEntity();
        carService.saveCar(car);
        return new ResponseEntity<>(carDto, HttpStatus.OK);
    }
}