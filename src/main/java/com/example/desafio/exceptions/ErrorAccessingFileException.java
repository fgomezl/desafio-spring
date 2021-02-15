package com.example.desafio.exceptions;

public class ErrorAccessingFileException extends RuntimeException{
    public ErrorAccessingFileException() {
    }

    public ErrorAccessingFileException(String message) {
        super(message);
    }
}
