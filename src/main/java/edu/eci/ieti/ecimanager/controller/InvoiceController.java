package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.repository.InvoiceRepository;
import edu.eci.ieti.ecimanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<?> getInvoices() {
        try {
            return new ResponseEntity<>(invoiceRepository.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer todas la facturas", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(invoiceRepository.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer la factura con ese identificador", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> findByStudentId(@PathVariable String studentId) {
        try {
            return new ResponseEntity<>(invoiceRepository.findByStudent(studentRepository.findById(studentId)), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No fue posible traer todas la facturas de este estudiante", HttpStatus.FORBIDDEN);
        }
    }

}