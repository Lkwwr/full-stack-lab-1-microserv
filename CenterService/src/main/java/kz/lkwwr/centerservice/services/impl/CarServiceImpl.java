package kz.lkwwr.centerservice.services.impl;

import kz.lkwwr.centerservice.entities.Car;
import kz.lkwwr.centerservice.repositories.CarRepository;
import kz.lkwwr.centerservice.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }
}
