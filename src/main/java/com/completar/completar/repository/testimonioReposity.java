
package com.completar.completar.repository;

import com.completar.completar.modelo.Testimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testimonioReposity extends JpaRepository <Testimonio,Long>{
    
}
