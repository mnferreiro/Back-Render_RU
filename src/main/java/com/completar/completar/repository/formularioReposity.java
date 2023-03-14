
package com.completar.completar.repository;

import com.completar.completar.modelo.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface formularioReposity extends JpaRepository <Formulario, Long>{
    
}
