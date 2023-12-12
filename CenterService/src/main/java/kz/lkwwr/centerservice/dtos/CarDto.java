package kz.lkwwr.centerservice.dtos;

import kz.lkwwr.centerservice.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String body;
    private int cost;

    public Car toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Car.class);
    }
}
