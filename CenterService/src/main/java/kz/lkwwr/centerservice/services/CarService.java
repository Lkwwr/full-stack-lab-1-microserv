package kz.lkwwr.centerservice.services;


import kz.lkwwr.centerservice.dtos.CarDTO;
import kz.lkwwr.centerservice.entities.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);

    List<Car> getAllCars();

    Car getCar(Long id);

    void saveCar(Car car);

    void deleteCar(Car car);

    CarDTO convertToDTO(Car car);
}