package kz.lkwwr.centerservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.lkwwr.centerservice.entities.Center;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"employees"})
public class CenterDto {
    private Long id;
    private String name;
    private List<EmployeeDto> employees;

    public Center toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Center.class);
    }
}
