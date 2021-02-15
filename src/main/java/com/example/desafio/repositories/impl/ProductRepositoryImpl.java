package com.example.desafio.repositories.impl;

import com.example.desafio.dto.ProductDTO;
import com.example.desafio.exceptions.ErrorAccessingFileException;
import com.example.desafio.repositories.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<ProductDTO> loadInventory() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:inventory.json");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            throw new ErrorAccessingFileException("No se encontró el archivo JSON");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ProductDTO>> typeRef = new TypeReference<>() {};
        List<ProductDTO> products = null;
        try {
            products = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            //e.printStackTrace();
            throw new ErrorAccessingFileException("Error accediendo al archivo JSON.");
        }
        return products;
    }

}
