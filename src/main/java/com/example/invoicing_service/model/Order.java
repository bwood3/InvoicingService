package com.example.invoicing_service.model;

import java.util.List;

public record Order(int id,
                    int customerId,
                    float total,
                    Address shippingAddress,
                    List<OrderItem> items,
                    Payment payment) {
}
