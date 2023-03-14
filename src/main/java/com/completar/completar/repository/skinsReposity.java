
package com.completar.completar.repository;

import com.completar.completar.modelo.Skins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface skinsReposity extends JpaRepository <Skins, Long>{
    
}
