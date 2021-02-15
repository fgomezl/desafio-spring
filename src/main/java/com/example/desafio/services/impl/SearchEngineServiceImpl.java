package com.example.desafio.services.impl;

import com.example.desafio.dto.ProductDTO;
import com.example.desafio.repositories.ProductRepository;
import com.example.desafio.services.SearchEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SearchEngineServiceImpl implements SearchEngineService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> search(Map<String, String> filters, Integer order) {

        if (order == null)
            order = 0;
        HashMap<Integer, ProductDTO> results = productRepository.searchProducts(filters, order);
        List<ProductDTO> list = new ArrayList<>();

        for (Map.Entry mapElement : results.entrySet()) {
            ProductDTO value = (ProductDTO) mapElement.getValue();
            list.add(value);
        }
        return list;
    }
}
