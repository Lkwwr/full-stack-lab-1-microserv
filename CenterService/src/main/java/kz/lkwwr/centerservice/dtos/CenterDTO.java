package kz.lkwwr.centerservice.dtos;

import kz.lkwwr.centerservice.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CenterDTO {
    private Long id;
    private String name;
    private Set<Employee> employees;
}
