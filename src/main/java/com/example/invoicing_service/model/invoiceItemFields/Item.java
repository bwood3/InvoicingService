package com.example.invoicing_service.model.invoiceItemFields;

public class Item {

//    @NotEmpty(message = "Shipping Address \"state\" must not be empty")
    private String item;
    private int quantity;
    private double price;
    private int itemId;

    private String itemStatus;
    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public void setItemId(int id)
    {
        this.itemId = id;
    }

    public int getItemId() {
        return this.itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
