package com.example.desafio.dto;

public class ProductRequestDTO {
    private Integer productId;
    private Integer discount;
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductRequestDTO{" +
                "productId=" + productId +
                ", discount=" + discount +
                ", quantity=" + quantity +
                '}';
    }
}
