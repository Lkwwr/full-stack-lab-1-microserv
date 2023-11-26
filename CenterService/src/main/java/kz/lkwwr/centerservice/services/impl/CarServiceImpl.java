package kz.lkwwr.centerservice.services.impl;

import kz.lkwwr.centerservice.dtos.CarDTO;
import kz.lkwwr.centerservice.entities.Car;
import kz.lkwwr.centerservice.repositories.CarRepository;
import kz.lkwwr.centerservice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(Long id) {
        return carRepository.getReferenceById(id);
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public CarDTO convertToDTO(Car car) {
        CarDTO carDTO = new CarDTO();

        carDTO.setId(car.getId());
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setBody(car.getBody());
        carDTO.setCost(car.getCost());

        return carDTO;
    }
}
