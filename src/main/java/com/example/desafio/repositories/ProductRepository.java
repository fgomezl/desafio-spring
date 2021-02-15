package com.example.desafio.repositories;

import com.example.desafio.dto.ProductDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductRepository {
    List<ProductDTO> loadInventory();
}
