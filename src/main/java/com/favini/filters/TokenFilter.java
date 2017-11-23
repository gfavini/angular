/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.filters;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author Gustavo
 */
public class TokenFilter extends GenericFilterBean{

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse res = (HttpServletResponse) sr1;
        
        String header = req.getHeader("Authorization");
        
        if(header == null || !header.startsWith("Bearer ")){
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Authorization header needed");
            return ;
            //throw new ServletException("Token inexistente ou invalido");
        }
        
        String token = header.substring(7); //Extraindo somente a String do token sem o bearer
        
        //Verificar se o token é valido
        try{
        Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
        }catch(JwtException e){
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
            //throw new ServletException("Token invalido: " + e.getMessage());
        }        
        fc.doFilter(sr, sr1);       
    }    
}
