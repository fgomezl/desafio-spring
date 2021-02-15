package com.example.desafio.services;

import com.example.desafio.dto.PurchaseRequestDTO;
import com.example.desafio.dto.PurchaseResponseDTO;

public interface PurchaseEngineService {
    PurchaseResponseDTO createOrder (PurchaseRequestDTO order);
}
