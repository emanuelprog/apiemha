package com.br.gov.ms.campogrande.apiemha.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
