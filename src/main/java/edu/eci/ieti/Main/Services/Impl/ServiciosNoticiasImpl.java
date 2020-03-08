/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services.Impl;

import edu.eci.ieti.Main.Model.Noticia;
import edu.eci.ieti.Main.Services.ServiciosNoticias;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author andres.rodriguez-de
 */
@Service
public class ServiciosNoticiasImpl implements ServiciosNoticias{
    public List<Noticia> noticias;
    @Override
    public Noticia getById(int id) {
        Noticia res=null;
        for(Noticia e:noticias){
            if(e.getId()==id){
                res=e;
            }
        }
        return res;
    }
    
}
