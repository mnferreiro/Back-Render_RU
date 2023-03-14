
package com.completar.completar.service;

import com.completar.completar.modelo.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public List<Experiencia> getExperiencia ();
     
    public void nuevoExperiencia(Experiencia exp);
    
public void borrarExperiencia (Long id);
    
public Experiencia buscarExperiencia (Long id);
    
public void editarExperiencia (Experiencia exp);
}
