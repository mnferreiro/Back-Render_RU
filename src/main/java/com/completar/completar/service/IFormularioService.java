
package com.completar.completar.service;

import com.completar.completar.modelo.Formulario;
import java.util.List;


public interface IFormularioService {
    
    public List<Formulario> getFormulario();
    
    public void nuevoFormulario(Formulario formu);
    
    public void borrarFormulario (Long id);
    
    public Formulario buscarFormulario (Long id);
    
    
}
