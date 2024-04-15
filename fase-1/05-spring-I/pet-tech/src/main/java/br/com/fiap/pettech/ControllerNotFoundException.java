package br.com.fiap.pettech;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String mensagem) {
        super(mensagem);
    }
}
