package com.example.invoicing_service.controller;

import com.example.invoicing_service.model.*;
import com.example.invoicing_service.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoicingController {
    @Autowired
    private InvoiceRepository invoiceRepository;

    private final WebClient orderService;

    public InvoicingController(WebClient.Builder webClientBuilder) {
        orderService = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    @GetMapping("/{orderId}")
    public Invoice findByOrderId(@PathVariable int orderId) {
        Order order = orderService.get().uri("/orders/order/{orderId}", orderId)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with this ID does not exist in the system"))
                )
                .bodyToMono(Order.class).block();

        if (order == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with this ID does not exist in the system");
        }

        Invoice invoice = new Invoice();
        invoice.setId(order.getId());
        invoice.setOrderPlaced(LocalDate.now());
        invoice.setTotal(order.getTotal());
        invoice.setPayment(order.getPayment());

        List<InvoiceItem> invoiceItems = new ArrayList<>();
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setStatus("shipping now");
        invoiceItem.setOn(new Date());
        invoiceItem.setAddress(order.getShippingAddress());
        invoiceItem.setItems(order.getItems());
        invoiceItem.setInvoice(invoice);  // Set the parent Invoice of the InvoiceItem
        invoiceItems.add(invoiceItem);

        invoice.setInvoiceItems(invoiceItems);
        invoiceRepository.save(invoice);
        System.out.println("Saved InvoiceItem with ID: " + invoiceItem.getId());

        return invoice;
    }

//    @PutMapping("/{orderId}")
//    public void updateItemStatus(@PathVariable int orderId, @RequestBody UpdateItem request) {
//        // You can get the itemId and status from the request object
//        int itemId = request.getItemId();
//        String status = request.getStatus();
//
//        boolean update = invoiceRepository.updateItemStatus(orderId, itemId, status);
//
//        System.out.println(update);
//    }
}
