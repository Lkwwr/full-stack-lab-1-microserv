package kz.lkwwr.centerservice.entities;

import kz.lkwwr.centerservice.dtos.CarDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "cost", nullable = false)
    private int cost;

    public CarDto toDTO() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, CarDto.class);
    }
}