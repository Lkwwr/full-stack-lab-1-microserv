package kz.lkwwr.centerservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.lkwwr.centerservice.dtos.CenterDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "centers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Employee> employees;

    public CenterDto toDTO() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, CenterDto.class);
    }
}