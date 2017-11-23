/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.services;

import com.favini.domain.Estado;
import com.favini.repository.EstadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gustavo
 */
@Service
public class EstadoService {
    
    @Autowired
    EstadoRepository estadoRepository;
    
    public List<Estado> findAllEstado(){
        return estadoRepository.findAll();
    }
    
    public Estado findById(Integer id){
        return estadoRepository.findOne(id);
    }
    
    public void saveEstado(Estado estado){
        Estado e;
        e = estadoRepository.save(estado);
        estado.setId(e.getId());
    }
    
    public void deleteById(Integer id){
        estadoRepository.delete(id);
    }
    
    
}
