package com.example.desafio.services.impl;

import com.example.desafio.dto.ProductDTO;
import com.example.desafio.repositories.ProductRepository;
import com.example.desafio.services.SearchEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchEngineServiceImpl implements SearchEngineService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProductList(Map<String, String> filters, Integer order) {
        HashMap<Integer, ProductDTO> results = searchProducts(filters, order);
        List<ProductDTO> list = new ArrayList<>();

        for (Map.Entry mapElement : results.entrySet()) {
            ProductDTO value = (ProductDTO) mapElement.getValue();
            list.add(value);
        }
        return list;
    }

    @Override
    public HashMap<Integer, ProductDTO> searchProducts(Map<String, String> filters, Integer order) {
        List<ProductDTO> filteredList = productRepository.loadInventory().stream().collect(Collectors.toList());
        HashMap<Integer, ProductDTO> mapOfProducts = new HashMap<>();

        if (filters!=null && filters.size() > 0) {
            for (Map.Entry mapElement : filters.entrySet()) {
                String key = (String)mapElement.getKey();
                String value = (String)mapElement.getValue();

                filteredList = filteredList.stream()
                        .filter(ProductDTO -> matchWith(key, value, ProductDTO))
                        .collect(Collectors.toList());
            }
        }
        if (order != null) {
            filteredList = orderList(filteredList, order);
        }
        int idCounter = 1;
        for (ProductDTO product: filteredList) {
            mapOfProducts.put(idCounter, product);
            idCounter++;
        }
        return mapOfProducts;
    }

    private boolean matchWith(String filter, String query, ProductDTO ProductDTO) {
        if (filter.equals("name"))
            return ProductDTO.getName().equalsIgnoreCase(query);
        else if (filter.equals("category"))
            return ProductDTO.getCategory().equalsIgnoreCase(query);
        else if (filter.equals("brand"))
            return ProductDTO.getBrand().equalsIgnoreCase(query);
        else if (filter.equals("price"))
            return ProductDTO.getPrice().equals(Integer.parseInt(query));
        else if (filter.equals("stock"))
            return ProductDTO.getStock().equals(Integer.parseInt(query));
        else if (filter.equals("freeShipping"))
            return ProductDTO.getFreeShipping().equals(Boolean.parseBoolean(query));
        else if (filter.equals("prestige"))
            return ProductDTO.getPrestige().toUpperCase().equals(query.toUpperCase());
        else return false;
    }

    public List<ProductDTO> orderList(List<ProductDTO> list, Integer method) {
        switch (method) {
            case (0): //Ascending by name
                return list.stream().sorted(Comparator.comparing(ProductDTO::getName)).collect(Collectors.toList());
            case (1): //Descending by name
                return list.stream().sorted(Comparator.comparing(ProductDTO::getName).reversed()).collect(Collectors.toList());
            case (2): //Descending by price
                return list.stream().sorted(Comparator.comparing(ProductDTO::getPrice).reversed()).collect(Collectors.toList());
            case (3): //Ascending by price
                return list.stream().sorted(Comparator.comparing(ProductDTO::getPrice)).collect(Collectors.toList());
            default:
                return list;
        }
    }
}
