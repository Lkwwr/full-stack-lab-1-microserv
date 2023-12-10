package kz.lkwwr.centerservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String body;
    private int cost;
}
