package com.example.invoicing_service.model;

public class UpdateShipping {
    private int itemID;
    private String status;

    public int getItemId() {
        return itemID;
    }

    public void setItemId(int itemID) {
        this.itemID = itemID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
