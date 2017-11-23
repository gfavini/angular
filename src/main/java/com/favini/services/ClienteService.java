/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.services;

import com.favini.domain.Cliente;
import com.favini.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gustavo
 */
@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public List<Cliente> findAllCliente(){
        return clienteRepository.findAll();
    }
    
    public Cliente findById(Integer id){
        return clienteRepository.findOne(id);
    }
    
    public List<Cliente> findByName(String name){
        return clienteRepository.findByName(name);
    }
    
    public void saveCliente(Cliente cliente){
        Cliente c;
        c = clienteRepository.save(cliente);
        cliente.setId(c.getId());
    }
    
    public void deleteById(Integer id){
            clienteRepository.delete(id);
    }
    
}
