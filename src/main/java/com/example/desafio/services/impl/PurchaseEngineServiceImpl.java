package com.example.desafio.services.impl;

import com.example.desafio.dto.PurchaseRequestDTO;
import com.example.desafio.dto.PurchaseResponseDTO;
import com.example.desafio.repositories.PurchaseRepository;
import com.example.desafio.services.PurchaseEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseEngineServiceImpl implements PurchaseEngineService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Override
    public PurchaseResponseDTO createOrder(PurchaseRequestDTO order) {
        return purchaseRepository.createOrder(order);
    }
}
