/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Persistence;

import edu.eci.ieti.Main.Model.Factura;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public interface FacturaPersistence {
    public List<Factura> getAllFacturas();
    public Factura getFacturaById(int idFactura);
    public List<Factura> getFacturaByStudentId(int idStudent);
}
