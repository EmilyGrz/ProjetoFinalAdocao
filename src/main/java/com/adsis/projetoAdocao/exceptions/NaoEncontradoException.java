package com.adsis.projetoAdocao.exceptions;

public class NaoEncontradoException extends RuntimeException{
    public NaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
