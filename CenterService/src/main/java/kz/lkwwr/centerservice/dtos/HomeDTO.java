package kz.lkwwr.centerservice.dtos;

import kz.lkwwr.centerservice.entities.Car;
import kz.lkwwr.centerservice.entities.Center;
import kz.lkwwr.centerservice.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeDTO {
    private List<Car> cars;
    private List<Center> centers;
    private List<Employee> employees;
}
