package com.example.desafio.dto;

public class PurchaseResponseDTO {
    private ReceiptDTO receipt;
    private StatusCodeDTO statusCode;

    public PurchaseResponseDTO(ReceiptDTO receipt) {
        this.receipt = receipt;
    }

    public PurchaseResponseDTO() {
    }

    public ReceiptDTO getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptDTO receipt) {
        this.receipt = receipt;
    }

    public StatusCodeDTO getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCodeDTO statusCode) {
        this.statusCode = statusCode;
    }
}
