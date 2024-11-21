package com.example.gs2.domain;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotEmpty
    private String username;

    @NotEmpty
    @Size(min = 6, message = "A senha deve ter no minimo 6 caracteres")
    private String password;
}
