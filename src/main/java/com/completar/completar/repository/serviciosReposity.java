
package com.completar.completar.repository;

import com.completar.completar.modelo.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface serviciosReposity extends JpaRepository <Servicios, Long>{
    
}
