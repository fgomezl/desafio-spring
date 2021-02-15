package com.example.desafio.repositories;

import com.example.desafio.dto.ProductDTO;

import java.util.HashMap;
import java.util.Map;

public interface ProductRepository {
    HashMap<Integer, ProductDTO> searchProducts(Map<String, String> filter, Integer order);
}
