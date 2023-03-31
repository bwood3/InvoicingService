package com.example.invoicing_service.model.paymentFields;

import com.example.invoicing_service.model.paymentFields.BillingAddress;

public class Payment {

    private String method;
    private String number;
    private BillingAddress billingAddress;

//    public Payment(String method, int number, BillingAddress billingAddress) {
//        this.method = method;
//        this.number = number;
//        this.billingAddress = billingAddress;
//    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
}
