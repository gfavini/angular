
package com.favini.controller;

import com.favini.domain.Cliente;
import com.favini.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *Controlador de Clientes
 * @author Gustavo
 */
@RestController
@RequestMapping(value="/admin")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    /**
     * Retorna todos os meu cliente para o browser no formado JASON
     * @return ResponseEntity
     */
    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> findAllClientes(){  
        return new ResponseEntity<>(clienteService.findAllCliente(),HttpStatus.OK);
    }
    
    @GetMapping(value = "/clientes/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }
    /**
     * 
     * @param name
     * @return ResponseEntity
     */
    @GetMapping(value = "/clientes/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> findByName(@PathVariable("name") String name){        
        return new ResponseEntity<>(clienteService.findByName(name), HttpStatus.OK);
    }
    
    /**Recebe uma solicitação POST com um cliente no formato JSAON
     * e salva um novo cliente na minha tabela de clientes
     * 
     * @param cliente
     * @return ResponseEntity
     */
    @PostMapping(value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> salvaCliente(@RequestBody Cliente cliente){        
        clienteService.saveCliente(cliente);        
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/clientes/{id}")
    public ResponseEntity<List> deleteById(@PathVariable("id") Integer id){
        if (clienteService.findById(id) != null){
            clienteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
}
