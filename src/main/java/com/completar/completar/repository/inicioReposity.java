
package com.completar.completar.repository;

import com.completar.completar.modelo.Inicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface inicioReposity extends JpaRepository <Inicio, Long>{
    
}
