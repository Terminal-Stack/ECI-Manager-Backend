/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ieti.Main.Services;

import edu.eci.ieti.Main.Model.Noticia;

/**
 *
 * @author andres.rodriguez-de
 */
public interface ServiciosNoticias {
    public Noticia getById(String id);
}
