
package com.completar.completar.repository;

import com.completar.completar.modelo.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface educacionReposity extends JpaRepository <Educacion, Long>{
}
