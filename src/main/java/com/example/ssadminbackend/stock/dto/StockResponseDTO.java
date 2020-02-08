package com.example.ssadminbackend.stock.dto;

public class StockResponseDTO {
    public long id;
    public String description;
    public int quantity;

    public StockResponseDTO(Long id, String description, int quantity) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
    }

}
