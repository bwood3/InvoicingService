package com.example.invoicing_service.model;

public record Payment(int id,
                      String method,
                      String number,
                      Address billingAddress) {
}
