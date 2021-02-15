package com.example.desafio.services;

import com.example.desafio.dto.ProductDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SearchEngineService {
    HashMap<Integer, ProductDTO> searchProducts(Map<String, String> filter, Integer order);
    List<ProductDTO> getProductList(Map<String, String> filters, Integer order);
}
