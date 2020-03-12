package edu.eci.ieti.Main.controllers;

import edu.eci.ieti.Main.Model.Factura;
import edu.eci.ieti.Main.Model.Noticia;
import edu.eci.ieti.Main.Services.ServiciosFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/Facturas")
public class FacturaController {
    @Autowired
    private ServiciosFactura servFactura;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllFacturas() {
        try {
            return new ResponseEntity<>(servFactura.getAllFacturas(),HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path ="/{facturaId}")
    public ResponseEntity<?> getFacturaById(@PathVariable int facturaId) {
        try {
            return new ResponseEntity<>(servFactura.getFacturaById(facturaId),HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path ="/{estudianteId}")
    public ResponseEntity<?> getFacturaByStudentId(@PathVariable int estudianteId) {
        try {
            return new ResponseEntity<>(servFactura.getFacturaByStudentId(estudianteId),HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }

}