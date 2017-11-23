/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.services;

import com.favini.domain.Usuario;
import com.favini.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gustavo
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository  usuariorRepository;
    
    public List<Usuario> findAllUsuario(){
        return usuariorRepository.findAll();
    }
    
    public Usuario findById(Integer id){
        return usuariorRepository.findOne(id);
    }
    
    public Usuario findByNome(String nome){
        return usuariorRepository.findByNome(nome);
    }
    
    public void saveUsuario(Usuario usuario){
        Usuario u;
        u = usuariorRepository.save(usuario);
        usuario.setId(u.getId());
    }
    
    public void deleteById(Integer id){
        usuariorRepository.delete(id);
    }
}
