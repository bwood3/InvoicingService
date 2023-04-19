package com.example.invoicing_service.model;

import com.example.invoicing_service.repository.InvoiceRepository;
import org.aspectj.weaver.ast.Or;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class DataUpdate {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice getInvoiceById(int id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public boolean updateItemStatus(int invoiceId, int itemId, String status) {

        Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
        System.out.println(invoice);

        try {
            InvoiceItem i = invoice.getInvoiceItems().get(0);
            System.out.println(i.getItems());
            i.setStatus(status);
            invoiceRepository.save(invoice);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
