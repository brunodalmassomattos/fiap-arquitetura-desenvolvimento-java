package br.com.fiap.pettech.controller.exception;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String mensagem) {
        super(mensagem);
    }
}
