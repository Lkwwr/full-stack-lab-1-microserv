package kz.lkwwr.authservice.dtos;

import kz.lkwwr.authservice.entities.Role;
import kz.lkwwr.authservice.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private List<Role> roles;

    public User toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, User.class);
    }
}
