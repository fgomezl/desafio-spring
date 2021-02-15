package com.example.desafio.dto;


import java.util.List;

public class ReceiptDTO {
    private Integer id;
    private String status;
    private List<ProductDTO> articles;
    private Float totalCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ProductDTO> articles) {
        this.articles = articles;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }
}
