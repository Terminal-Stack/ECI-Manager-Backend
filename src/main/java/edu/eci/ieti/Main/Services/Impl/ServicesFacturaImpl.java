/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services.Impl;

import edu.eci.ieti.Main.Model.Factura;
import edu.eci.ieti.Main.Repository.FacturaRepository;
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
    
    @Autowired
    FacturaRepository fr = null ;

    @Override
    public List<Factura> getAllFacturas() {
        return fr.findAll();
    }

    @Override
    public Factura getFacturaById(String idFactura) {
        List<Factura> facturas = fr.findAll();
        Factura res=null;
        for(Factura f:facturas){
            if(f.getId().equals(idFactura)){
                res=f;
            }
        }
        return res;
    }

    @Override
    public List<Factura> getFacturaByStudentId(int idStudent) {
        return getFacturaByStudentId(idStudent);
    }
    
}
