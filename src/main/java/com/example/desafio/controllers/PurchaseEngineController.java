package com.example.desafio.controllers;

import com.example.desafio.dto.PurchaseRequestDTO;
import com.example.desafio.dto.PurchaseResponseDTO;
import com.example.desafio.dto.ReceiptDTO;
import com.example.desafio.dto.StatusCodeDTO;
import com.example.desafio.exceptions.UnknownProductException;
import com.example.desafio.services.PurchaseEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PurchaseEngineController {
    
    @Autowired
    PurchaseEngineService purchaseEngineService;
    
    @PostMapping(value="api/v1/purchase-request")
    public PurchaseResponseDTO recieveOrder(@RequestBody PurchaseRequestDTO purchaseRequest) {
        PurchaseResponseDTO response = purchaseEngineService.createOrder(purchaseRequest);
        response.setStatusCode(new StatusCodeDTO(HttpStatus.OK.value(), "La solicitud se completó con exito."));

        return response;
    }
}
