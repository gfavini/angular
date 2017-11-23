/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.favini.repository;

import com.favini.domain.Cliente;
import com.favini.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gustavo
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    //Os dois metodos tem o mesmo objetico. Duas implementações de metodos com fins iguais    
    public Usuario findByNome(String name);
    
    @Query(value = "Select u from Usuario u where u.nome = :pnome")
    public Usuario buscaPorNome(@Param("pnome")String name);
    
}
