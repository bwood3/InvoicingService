package com.example.invoicing_service.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoice_item_items")
public class InvoiceItem {
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @ManyToOne
    private Invoice invoice;
    private String status = "pending";

    @Column(name = "on_date")
    private Date on;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOn() {
        return on;
    }

    public void setOn(Date on) {
        this.on = on;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
