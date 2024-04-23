package br.com.fiap.apiredesocial.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record UserDTO(
        String id,
        @NotBlank(message = "O nome é obrigatorio.") String name,
        @NotBlank(message = "O email é obrigatorio.")
        @Email(message = "email invalido.") String email,
        @NotBlank(message = "O password é obrigatorio.") String password) implements Serializable {
}
