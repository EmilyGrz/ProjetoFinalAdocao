package com.adsis.projetoAdocao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerExceptions {
    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<Object> NaoEncontradoExceptionHandler(NaoEncontradoException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", "Objeto não encontrado!");
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("Data do erro", new Date());
        body.put("mensagem", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
