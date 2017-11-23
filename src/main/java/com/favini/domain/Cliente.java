/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.json.JSONObject;


/**
 *
 * @author Gustavo
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    
    private String name;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    
    public Cliente(){
    }
    
    public Cliente(String name){
        this.name= name;
    }
    
    public Cliente(String name, String email){
        this.name= name;
        this.email = email;
    }
    
    public Cliente(String name, String email, Estado estado){
        this.name= name;
        this.email = email;
        this.estado = estado;
    }
    

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        jsonInfo.put("name",this.name);
        
        JSONObject estadoObj = new JSONObject();
        estadoObj.put("id", this.estado.getId());
        estadoObj.put("uf", this.estado.getUf());
        jsonInfo.put("estado", estadoObj);
        
        info = jsonInfo.toString();
        return info;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (id == null || obj == null || getClass() != obj.getClass()){
             return false;
        }
        Cliente that = (Cliente) obj;
        return id.equals(that.id);

    }
    

    
}
