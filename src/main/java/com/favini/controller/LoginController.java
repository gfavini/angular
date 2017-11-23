/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.controller;

import com.favini.domain.Usuario;
import com.favini.services.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gustavo
 */
@RestController
public class LoginController {
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse autenticar (@RequestBody Usuario usuario) throws ServletException{
//        System.out.println(usuario.toString());
        if (usuario.getNome() == null || usuario.getSenha()==null){
            throw new ServletException("Usuario e senha são obrigatórias.");
        }
        Usuario u = usuarioService.findByNome(usuario.getNome());
        
        if(u == null){
            throw new ServletException("Usuario nao encontrado.");
        }
        
        if(!u.getSenha().equals(usuario.getSenha())) {
            throw new ServletException("Usuario ou senha invalidos.");            
        }
        
        System.out.println(u.toString());
        
//        return new ResponseEntity<>(u, HttpStatus.OK);
        //Deve retornar token e nao o usuario
        // A ideia é criar um objeto Token e enviar todo o objeto
        //LoginResponse foi criado para responsta, não é padrão (classe interna)
        
        //a chave da criptografia é banana
        String token = Jwts.builder()
                .setSubject(u.getNome())
                .signWith(SignatureAlgorithm.HS512, "banana")
                .setExpiration(new Date(System.currentTimeMillis()+ 1 * 60 * 1000))
                .compact();
        
        return new LoginResponse(token);       
    }
    
    private class LoginResponse{
        
        //a proprietaria precisa ser public para o framework conseguir gerar o JSON
        public String token;
        LoginResponse(String token){
            this.token= token;
        }        
    }
    
}
