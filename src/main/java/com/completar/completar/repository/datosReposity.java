
package com.completar.completar.repository;

import com.completar.completar.modelo.Datos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface datosReposity extends JpaRepository <Datos, Long>{
    
}
