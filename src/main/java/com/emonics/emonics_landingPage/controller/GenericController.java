package com.emonics.emonics_landingPage.controller;

import com.emonics.emonics_landingPage.service.contracts.GenericDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericController <E, S extends GenericDAO<E>>{
    protected final S service;
    protected String entitie;

    public GenericController(S service) {
        this.service = service;
    }

    //GetAll
    @GetMapping
    public ResponseEntity<?> findAll(){
        Map<String, Object> mensaje = new HashMap<>();
        List<E> result = (List<E>) service.findAll();
        if (result.isEmpty()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existen %ss", entitie));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", result);

        return ResponseEntity.ok(mensaje);
    }

    //FindByID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<E> result = service.findById(id);
        if (!result.isPresent()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existen %ss", entitie));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", result);

        return ResponseEntity.ok(mensaje);
    }

    //Save
    @PostMapping
    public ResponseEntity<?> saveEntitie(@RequestBody E object){
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", service.save(object));

        return ResponseEntity.ok(mensaje);
    }


    //Delete
    @DeleteMapping("/{id}")
    public void deleteEntitie(@PathVariable("id")Integer id){
        service.deleteById(id);
    }
}
