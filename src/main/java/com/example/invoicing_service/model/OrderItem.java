package com.example.invoicing_service.model;

public record OrderItem(int id,
                        String name,
                        int quantity,
                        float price) {
    public int getId() {
        return 0;
    }
}
