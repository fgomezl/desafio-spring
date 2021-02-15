package com.example.desafio.exceptions;

public class UnknownProductException extends RuntimeException{
    public UnknownProductException() {
    }

    public UnknownProductException(String message) {
        super(message);
    }
}
