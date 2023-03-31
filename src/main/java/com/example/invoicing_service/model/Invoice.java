package com.example.invoicing_service.model;

import com.example.invoicing_service.model.paymentFields.Payment;

public class Invoice {
    private InvoiceItem invoiceItem;
    private Payment payment;

    private Double total;

    //date order was placed
    private String orderPlaced;

    private int orderID;


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public InvoiceItem getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(String orderPlaced) {
        this.orderPlaced = orderPlaced;
    }
}
