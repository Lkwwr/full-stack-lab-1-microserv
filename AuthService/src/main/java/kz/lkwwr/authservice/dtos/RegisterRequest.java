package kz.lkwwr.authservice.dtos;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String username;
    private String password;
}
