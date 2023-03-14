
package com.completar.completar.repository;


import com.completar.completar.modelo.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface experienciaReposity extends JpaRepository <Experiencia, Long>{
    
}
