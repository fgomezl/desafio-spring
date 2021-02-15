package com.example.desafio.services;

import com.example.desafio.dto.ProductDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SearchEngineService {
    List<ProductDTO> search(Map<String, String> filters, Integer order);
}
