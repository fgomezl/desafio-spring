package com.example.desafio.controllers;

import com.example.desafio.dto.ProductDTO;
import com.example.desafio.services.SearchEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;


@RestController
public class SearchEngineController {

    @Autowired
    SearchEngineService searchEngineService;
    
    @GetMapping(value="api/v1/articles")
    public List<ProductDTO> find(
            @Nullable @RequestParam(value="name") String name,
            @Nullable @RequestParam(value="category") String category,
            @Nullable @RequestParam(value="brand") String brand,
            @Nullable @RequestParam(value="price") String price,
            @Nullable @RequestParam(value="stock") String stock,
            @Nullable @RequestParam(value="freeShipping") String freeShipping,
            @Nullable @RequestParam(value="prestige") String prestige,
            @Nullable @RequestParam(value="order") Integer order) {

        HashMap<String, String> filters = new HashMap<>();

        if (name != null) filters.put("name", name);
        if (category != null) filters.put("category", category);
        if (brand != null) filters.put("brand", brand);
        if (price != null) filters.put("price", price);
        if (stock != null) filters.put("stock", stock);
        if (freeShipping != null) filters.put("freeShipping", freeShipping);
        if (prestige != null) filters.put("prestige", prestige);

        return searchEngineService.getProductList(filters, order);
    }
    
}
