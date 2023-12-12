package kz.lkwwr.centerservice.entities;

import kz.lkwwr.centerservice.dtos.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "center_id", referencedColumnName = "id")
    private Center center;

    public EmployeeDto toDTO() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, EmployeeDto.class);
    }
}
