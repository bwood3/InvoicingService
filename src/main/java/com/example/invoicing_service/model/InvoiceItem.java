package com.example.invoicing_service.model;

import com.example.invoicing_service.model.invoiceItemFields.Item;
import com.example.invoicing_service.model.invoiceItemFields.ShippingAddress;

import java.util.List;

public class InvoiceItem {

    //shipping or no
    private String status;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private List<Item> items;

    //arrival date??
    private String on;
    private ShippingAddress shippingAddress;

    public List<Item> getItems() {
        return items;
    }

    public Item findItemById(int id)
    {
//        System.out.println("ItemId " + id);
//        for(Item i:items) {
//            System.out.println(i.getItem());
//            System.out.println(i.getItemId());
//        }
        Item i = items.stream().filter(x -> x.getItemId() == id).findAny().orElse(null);
        return i;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
