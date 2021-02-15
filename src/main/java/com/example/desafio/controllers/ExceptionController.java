package com.example.desafio.controllers;

import com.example.desafio.dto.StatusCodeDTO;
import com.example.desafio.exceptions.BadRequestException;
import com.example.desafio.exceptions.ErrorAccessingFileException;
import com.example.desafio.exceptions.UnknownProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UnknownProductException.class)
    public ResponseEntity<StatusCodeDTO> handleException(UnknownProductException ex) {
        StatusCodeDTO statusCodeDTO = new StatusCodeDTO();
        statusCodeDTO.setCode(HttpStatus.NOT_FOUND.value());
        statusCodeDTO.setMessage(ex.getMessage());

        return new ResponseEntity<>( statusCodeDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ErrorAccessingFileException.class)
    public ResponseEntity<StatusCodeDTO> handleException(ErrorAccessingFileException ex) {
        StatusCodeDTO statusCodeDTO = new StatusCodeDTO();
        statusCodeDTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        statusCodeDTO.setMessage(ex.getMessage());

        return new ResponseEntity<>( statusCodeDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StatusCodeDTO> handleException(BadRequestException ex) {
        StatusCodeDTO statusCodeDTO = new StatusCodeDTO();
        statusCodeDTO.setCode(HttpStatus.BAD_REQUEST.value());
        statusCodeDTO.setMessage(ex.getMessage());

        return new ResponseEntity<>( statusCodeDTO, HttpStatus.BAD_REQUEST);
    }

}