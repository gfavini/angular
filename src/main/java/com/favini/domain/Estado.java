/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.json.JSONObject;

/**
 *
 * @author Gustavo
 */
@Entity
public class Estado implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String uf;
       
    public Estado(){}    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    @Override
    public String toString(){
    	String info = "";
        JSONObject jsonUf = new JSONObject();
        jsonUf.put("id",this.id);
        jsonUf.put("uf",this.uf);
        info = jsonUf.toString();
        return info;
    }

}
