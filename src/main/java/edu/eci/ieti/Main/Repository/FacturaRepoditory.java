/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Repository;

import edu.eci.ieti.Main.Model.Factura;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 *
 * @author anrodriguez
 */
public interface FacturaRepoditory  extends MongoRepository<Factura,String>{
    
}
