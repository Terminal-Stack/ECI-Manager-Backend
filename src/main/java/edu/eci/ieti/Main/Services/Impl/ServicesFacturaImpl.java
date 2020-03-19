/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services.Impl;

import edu.eci.ieti.Main.Model.Factura;
import edu.eci.ieti.Main.Services.ServiciosFactura;
import edu.eci.ieti.Persistence.FacturaPersistence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public class ServicesFacturaImpl implements ServiciosFactura{
    
    //@Autowired
    FacturaPersistence facturaPersistence = null ;

    @Override
    public List<Factura> getAllFacturas() {
        return facturaPersistence.getAllFacturas();
    }

    @Override
    public Factura getFacturaById(String idFactura) {
        return facturaPersistence.getFacturaById(idFactura);
    }

    @Override
    public List<Factura> getFacturaByStudentId(int idStudent) {
        return getFacturaByStudentId(idStudent);
    }
    
}
