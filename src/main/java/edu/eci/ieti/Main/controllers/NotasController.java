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


@RestController
@RequestMapping(value = "/Notas")
public class NotasController{
    @Autowired
    private ServiciosNotas servNotas;
    @RequestMapping(value = "/notas", method = RequestMethod.GET)
    public ResponseEntity<Notas> getById(@PathVariable String id) {
        Notas notas = servNoticias.getById(id);
        return new ResponseEntity<>(noticias,HttpStatus.OK);
    }
}