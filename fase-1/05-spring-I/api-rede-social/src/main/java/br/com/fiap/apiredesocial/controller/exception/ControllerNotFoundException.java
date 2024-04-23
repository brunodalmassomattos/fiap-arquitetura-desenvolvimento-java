package br.com.fiap.apiredesocial.controller.exception;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String mensagem) {
        super(mensagem);
    }
}
