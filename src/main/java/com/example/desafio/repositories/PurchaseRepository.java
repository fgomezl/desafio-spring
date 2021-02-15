package com.example.desafio.repositories;

import com.example.desafio.dto.PurchaseRequestDTO;
import com.example.desafio.dto.PurchaseResponseDTO;
import com.example.desafio.dto.ReceiptDTO;

public interface PurchaseRepository {
    PurchaseResponseDTO createOrder (PurchaseRequestDTO order);
}
