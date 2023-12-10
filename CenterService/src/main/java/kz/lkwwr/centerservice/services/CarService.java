package kz.lkwwr.centerservice.services;

import kz.lkwwr.centerservice.entities.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);

    List<Car> getCars();

    Car getCar(Long id);

    void saveCar(Car car);

    void deleteCar(Car car);
}