package com.emonics.emonics_landingPage.controller;

import com.emonics.emonics_landingPage.entities.User;
import com.emonics.emonics_landingPage.service.contracts.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/prospectos")
@CrossOrigin("http://localhost")
public class UserController extends GenericController<User, UserDAO>{

    @Autowired
    public UserController(UserDAO service) {
        super(service);
        entitie = "prospecto";
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable(value = "id")Integer id, @RequestBody User user){
        User update = null;
        Map<String, Object> mensaje = new HashMap<>();
        Optional<User> optionalTicket = service.findById(id);
        if (!optionalTicket.isPresent()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", "No se encontro ticket con id: "+id);
            return ResponseEntity.badRequest().body(mensaje);

        }
        update = optionalTicket.get();
        update.setEmail(user.getEmail());
        update.setFullName(user.getFullName());
        update.setPrimarySkill(user.getPrimarySkill());
        update.setSecondarySkill(user.getSecondarySkill());
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", service.save(update));
        return ResponseEntity.ok(mensaje);

    }
}
