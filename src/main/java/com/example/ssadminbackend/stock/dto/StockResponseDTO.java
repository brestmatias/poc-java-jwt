package com.example.ssadminbackend.stock.dto;

import com.example.ssadminbackend.stock.model.Stock;

public class StockResponseDTO {
    private Long id;
    private String description;
    private String type;
    private String color;
    private String size;
    private Integer quantity;
    private Double prize;

    public StockResponseDTO(Long id, String description, String type, String color, String size, Integer quantity, Double prize) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.prize = prize;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrize() {
        return prize;
    }

    public static StockResponseDTO valueOf(Stock entity) {
        return new StockResponseDTO(
                entity.getId(),
                entity.getDescription(),
                entity.getType(),
                entity.getColor(),
                entity.getSize(),
                entity.getQuantity(),
                entity.getPrize()
        );

    }

}
