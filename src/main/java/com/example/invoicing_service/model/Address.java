package com.example.invoicing_service.model;

public record Address(int id,
                      String state,
                      String city,
                      int postalCode) {
}
