package kz.lkwwr.centerservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.lkwwr.centerservice.entities.Center;
import kz.lkwwr.centerservice.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"center"})
public class EmployeeDto {
    private Long id;
    private String lastName;
    private String firstName;
    private int salary;
    private String email;
    private Center center;
    private Long centerId;

    public Employee toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Employee.class);
    }
}
