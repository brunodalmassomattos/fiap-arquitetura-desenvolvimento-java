package br.com.fiap.apiredesocial.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidateMessage {
    private String field;
    private String message;
}
