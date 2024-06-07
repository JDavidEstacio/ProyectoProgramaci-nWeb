package com.example.demospringfirestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospringfirestore.commons.GenericServiceImpl;
import com.example.demospringfirestore.dto.UsuariosDTO;
import com.example.demospringfirestore.model.Usuarios;
import com.example.demospringfirestore.service.api.UsuariosServiceAPI;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

@Service
public class UsuariosServiceImpl extends GenericServiceImpl<Usuarios, UsuariosDTO> implements UsuariosServiceAPI {
    
    @Autowired
    private Firestore firestore;
    
    public UsuariosServiceImpl() {
        super(UsuariosDTO.class);
    }

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("usuarios");
    }
}
