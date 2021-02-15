package com.example.desafio.repositories.impl;

import com.example.desafio.dto.*;
import com.example.desafio.exceptions.UnknownProductException;
import com.example.desafio.repositories.ProductRepository;
import com.example.desafio.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {

    @Autowired
    ProductRepository productRepository;

    @Override
    public PurchaseResponseDTO createOrder(PurchaseRequestDTO order) {
        ReceiptDTO receipt = new ReceiptDTO();
        receipt.setId(1001);
        receipt.setStatus("Pending");

        float totalCost = 0;

        HashMap<Integer, ProductDTO> temp = productRepository.searchProducts(null, null);

        System.out.println(order);

        List<ProductRequestDTO> entrada = order.getArticles();
        List<ProductDTO> salida = new ArrayList<>();

        for (ProductRequestDTO article: entrada) {
            if (temp.get(article.getProductId()) != null) {
                totalCost += article.getQuantity() * temp.get(article.getProductId()).getPrice() * (1 - (float) article.getDiscount()/100);
                salida.add(temp.get(article.getProductId()));
            } else {
                throw new UnknownProductException("No se encontró el producto con id " + article.getProductId());
            }
        }

        receipt.setArticles(salida);
        receipt.setTotalCost(totalCost);

        PurchaseResponseDTO responseDTO = new PurchaseResponseDTO(receipt);

        return responseDTO;
    }
}
