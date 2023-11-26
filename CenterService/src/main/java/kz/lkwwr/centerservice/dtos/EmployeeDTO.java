package kz.lkwwr.centerservice.dtos;

import kz.lkwwr.centerservice.entities.Center;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private int salary;
    private String email;
    private Center center;
}
