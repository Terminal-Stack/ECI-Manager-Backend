package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.InvoiceRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.InvoiceNotFoundException;
import edu.eci.ieti.ecimanager.exception.StudentNotFoundException;
import edu.eci.ieti.ecimanager.model.Invoice;
import edu.eci.ieti.ecimanager.repository.InvoiceRepository;
import edu.eci.ieti.ecimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InvoiceRepresentationModelAssembler invoiceRepresentationModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Invoice>> all() {
        List<EntityModel<Invoice>> invoices = invoiceRepository.findAll().stream()
                .map(invoiceRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(invoices, linkTo(InvoiceController.class).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Invoice> getInvoiceById(@PathVariable String id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));

        return invoiceRepresentationModelAssembler.toModel(invoice);
    }

    @GetMapping("/{studentId}")
    public CollectionModel<EntityModel<Invoice>> findByStudentId(@PathVariable Long studentId) {
        studentRepository.findByCollegeId(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
        List<EntityModel<Invoice>> invoices = invoiceRepository.findByStudentId(studentId).stream()
                .map(invoiceRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(invoices, linkTo(InvoiceController.class).withSelfRel());
    }

}