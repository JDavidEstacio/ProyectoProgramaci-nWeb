package com.example.demospringfirestore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demospringfirestore.dto.UsuariosDTO;

import com.example.demospringfirestore.model.Usuarios;

import com.example.demospringfirestore.service.api.UsuariosServiceAPI;

@RestController
@RequestMapping(value = "/usuarios/api/v1/") 
@CrossOrigin("*")
public class UsuariosController {

    @Autowired
    private UsuariosServiceAPI usuariosServiceAPI;

    @GetMapping(value = "/all")
    public List<UsuariosDTO> getAll() throws Exception {
        return usuariosServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public UsuariosDTO find(@PathVariable String id) throws Exception {
        return usuariosServiceAPI.get(id);
    }

    @PostMapping(value = "/save/{id}")
    public ResponseEntity<String> save(@RequestBody Usuarios usuarios, @PathVariable String id) throws Exception {
        if (id == null || id.length() == 0 || id.equals("null")) {
            id = usuariosServiceAPI.save(usuarios);
        } else {
            usuariosServiceAPI.save(usuarios, id);
        }
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<UsuariosDTO> delete(@PathVariable String id) throws Exception {
        UsuariosDTO usuarios = usuariosServiceAPI.get(id);
        if (usuarios != null) {
            usuariosServiceAPI.delete(id);
        } else {
            return new ResponseEntity<UsuariosDTO>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<UsuariosDTO>(usuarios, HttpStatus.OK);
    }
}
