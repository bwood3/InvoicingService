package com.example.invoicing_service.model;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private LocalDate orderPlaced;

    private float total;

    private List<InvoiceItem> invoiceItems;

    private Payment payment;

    public LocalDate getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(LocalDate orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
