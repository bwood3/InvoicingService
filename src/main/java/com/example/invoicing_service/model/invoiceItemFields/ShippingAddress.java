package com.example.invoicing_service.model.invoiceItemFields;

public class ShippingAddress {

//    @NotEmpty(message = "Shipping Address \"state\" must not be empty.")
    private String state;
//    @NotEmpty(message = "Shipping Address \"city\" must not be empty.")
    private String city;
    private int postalCode;

//    public ShippingAddress(String state, String city, int postalCode) {
//        this.state = state;
//        this.city = city;
//        this.postalCode = postalCode;
//    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
//        try
//        {
//            this.getPostalCode();
//        }catch (Exception i)
//        {
//            throw new IllegalStateException("Shipping postal must not be blank.");
//        }
        this.postalCode = postalCode;
    }
}
