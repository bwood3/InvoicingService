package com.example.invoicing_service.controller;

import com.example.invoicing_service.model.Invoice;
import com.example.invoicing_service.model.InvoiceItem;
import com.example.invoicing_service.model.Order;
import org.springframework.http.HttpStatusCode;
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
        invoice.setOrderPlaced(LocalDate.now());
        invoice.setTotal(order.total());
        invoice.setPayment(order.payment());

        List<InvoiceItem> invoiceItems = new ArrayList<>();
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setStatus("shipping now");
        invoiceItem.setOn(new Date());
        invoiceItem.setAddress(order.shippingAddress());
        invoiceItem.setItems(order.items());
        invoiceItems.add(invoiceItem);

        invoice.setInvoiceItems(invoiceItems);

        return invoice;
    }
}
