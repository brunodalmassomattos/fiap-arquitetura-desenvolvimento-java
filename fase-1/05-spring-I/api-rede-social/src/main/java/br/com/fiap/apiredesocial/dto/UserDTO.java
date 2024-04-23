package br.com.fiap.apiredesocial.dto;

import java.io.Serializable;

public record UserDTO(String name, String email, String password) implements Serializable {
}
