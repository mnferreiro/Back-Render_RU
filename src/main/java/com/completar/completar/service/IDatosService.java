
package com.completar.completar.service;

import com.completar.completar.modelo.Datos;
import java.util.List;


public interface IDatosService {
    public List<Datos> getDatos ();
    public void nuevoDatos(Datos datos);
    
  public void borrarDatos (Long id);
    
  public Datos buscarDatos (Long id);
    
  public void editarDatos (Datos datos); 
}
