package kz.lkwwr.centerservice.repositories;

import jakarta.transaction.Transactional;
import kz.lkwwr.centerservice.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String body);

    List<Car> findByBody(String body);
}