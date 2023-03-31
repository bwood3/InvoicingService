package com.example.invoicing_service.repository;

import com.example.invoicing_service.model.Invoice;
import com.example.invoicing_service.model.InvoiceItem;
import com.example.invoicing_service.model.UpdateShipping;
import com.example.invoicing_service.model.invoiceItemFields.Item;
import com.example.invoicing_service.model.invoiceItemFields.ShippingAddress;
import com.example.invoicing_service.model.paymentFields.BillingAddress;
import com.example.invoicing_service.model.paymentFields.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {
    private List<Invoice> invoices = loadTempDatabase();

    public int createInvoice(Invoice invoice)
    {
        if(getInvoiceByID(invoice.getOrderID()) == null)
            invoices.add(invoice);

        return invoice.getOrderID();
    }

    public List<Invoice> getAllOrders()
    {
        return invoices;
    }

    public Invoice getInvoiceByID(int id)
    {
        Invoice r = invoices.stream().filter(x -> x.getOrderID() == id).findAny().orElse(null);
        return r;
    }

    public void update(UpdateShipping updateShipping, int orderID)
    {
        int itemId = updateShipping.getItemId();
        Invoice i = getInvoiceByID(orderID);
        InvoiceItem items = i.getInvoiceItem();
        Item itemToUpdate = items.findItemById(itemId);
//        System.out.println(itemToUpdate.getItem());
        itemToUpdate.setItemStatus(updateShipping.getStatus());

    }

    //could have just created JSON file instead...
    private List<Invoice> loadTempDatabase()
    {
        Invoice i = new Invoice();
        i.setOrderPlaced("3/4/2023");
        i.setTotal(60.26);
        i.setOrderID(1);
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setStatus("shipping now");
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item();
        item1.setItemId(1);
        item1.setItem("Tea");
        item1.setQuantity(2);
        item1.setPrice(24.84);
        item1.setItemStatus("waiting to ship");
        Item item2 = new Item();
        item2.setItemId(2);
        item2.setItem("Turmeric Paste");
        item2.setQuantity(1);
        item2.setPrice(22.99);
        item2.setItemStatus("waiting to ship");
        itemList.add(item1);
        itemList.add(item2);
        invoiceItem.setItems(itemList);
        invoiceItem.setStatus("shipping now");
        invoiceItem.setOn("3/5/2023");
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setState("Indiana");
        shippingAddress.setCity("Bloomington");
        shippingAddress.setPostalCode(47408);
        invoiceItem.setShippingAddress(shippingAddress);
        Payment payment = new Payment();
        payment.setMethod("Discover");
        payment.setNumber("12345678");
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setState("Indiana");
        billingAddress.setCity("Bloomington");
        billingAddress.setPostalCode(47408);
        i.setPayment(payment);
        i.setInvoiceItem(invoiceItem);

        ArrayList<Invoice> dummyData = new ArrayList<>();
        dummyData.add(i);
        return dummyData;
    }
}
