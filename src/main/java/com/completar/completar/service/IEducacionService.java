
package com.completar.completar.service;

import com.completar.completar.modelo.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> getEducacion ();

public void nuevoEducacion(Educacion ski);
    
public void borrarEducacion (Long id);
    
public Educacion buscarEducacion (Long id);
    
public void editarEducacion (Educacion ski);
    
}
