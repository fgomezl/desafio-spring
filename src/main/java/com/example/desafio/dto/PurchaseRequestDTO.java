package com.example.desafio.dto;

import java.util.List;

public class PurchaseRequestDTO {
    private String username;
    private List<ProductRequestDTO> articles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ProductRequestDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ProductRequestDTO> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "PurchaseRequestDTO{" +
                "username='" + username + '\'' +
                ", articles=" + articles +
                '}';
    }
}
