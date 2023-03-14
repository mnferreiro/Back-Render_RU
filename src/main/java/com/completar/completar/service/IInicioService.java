
package com.completar.completar.service;

import com.completar.completar.modelo.Inicio;
import java.util.List;


public interface IInicioService {
    //Listar Usuarios Registrados
    List<Inicio> getInicio ();
    
    //Registrar Uusario, solo yo
    void nuevoInicio(Inicio ini);
    
    //Borrar Usuario
    void borrarInicio (Long id);
    
    //Buscar Usuario para ver si esta registrado
    Inicio buscarInicio (Inicio ini);
}
