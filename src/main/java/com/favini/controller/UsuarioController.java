/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.controller;

import com.favini.domain.Usuario;
import com.favini.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gustavo
 */
@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping(value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
}
