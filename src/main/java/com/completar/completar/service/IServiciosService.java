
package com.completar.completar.service;

import com.completar.completar.modelo.Servicios;
import java.util.List;


public interface IServiciosService {
    public List<Servicios> getServicios ();
    
    public void nuevoServicios(Servicios servi);
    
public void borrarServicios (Long id);
    
public Servicios buscarServicios (Long id);
    
public void editarServicios (Servicios servi);
}
