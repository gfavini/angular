/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.controller;

import com.favini.services.EstadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gustavo
 */
@RestController
public class EstadoController {
    
    @Autowired
    EstadoService estadoService;
    
    @GetMapping(value = "/estados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> findAllEstado(){
        return new ResponseEntity<>(estadoService.findAllEstado(),HttpStatus.OK);
    }
}
