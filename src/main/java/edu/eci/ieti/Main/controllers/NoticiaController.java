package edu.eci.ieti.Main.controllers;


import edu.eci.ieti.Main.Model.Estudiante;
import edu.eci.ieti.Main.Model.Noticia;
import edu.eci.ieti.Main.Services.ServiciosEstudiantes;
import edu.eci.ieti.Main.Services.ServiciosNoticias;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class NoticiaController{
    @Autowired
    private ServiciosNoticias servNoticias;

   
    @RequestMapping(value = "/noticias", method = RequestMethod.GET)
    public ResponseEntity<Noticia> getById(@PathVariable int id) {
        Noticia noticias = servNoticias.getById(id);
        return new ResponseEntity<>(noticias,HttpStatus.OK);
        
    }
}