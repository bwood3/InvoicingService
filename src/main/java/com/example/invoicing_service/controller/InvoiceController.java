package com.example.invoicing_service.controller;

import com.example.invoicing_service.model.Invoice;
import com.example.invoicing_service.model.UpdateShipping;
import com.example.invoicing_service.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private InvoiceRepository repository;

    public InvoiceController(InvoiceRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping
    public List<Invoice> findAll(){
        return repository.getAllOrders();
    }

    @GetMapping("/{id}")
    public Invoice findByID(@PathVariable int id){
        Invoice i = repository.getInvoiceByID(id);
        return i;
    }

    @PutMapping("/{id}")
    public void updateStatus(@RequestBody UpdateShipping update, @PathVariable int id)
    {
//        System.out.println(id);
//        System.out.println(update.getStatus());
//        System.out.println(update.getItemId());
        repository.update(update, id);
    }

}
