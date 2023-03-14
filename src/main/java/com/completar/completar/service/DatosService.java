
package com.completar.completar.service;

import com.completar.completar.modelo.Datos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.completar.completar.repository.datosReposity;

@Service
public class DatosService implements IDatosService{
    @Autowired
    private datosReposity datReposity;
    
    @Override
    public List<Datos> getDatos () {
        List<Datos> listaDatos = datReposity.findAll();
        return listaDatos; 
}
    @Override
    public void nuevoDatos(Datos datos) {
        datReposity.save(datos);
    }

    @Override
    public void borrarDatos(Long id) {
        datReposity.deleteById(id);
         }

    @Override
    public Datos buscarDatos(Long id) {
        return datReposity.findById(id).orElse(null);
          }

    @Override
    public void editarDatos(Datos datos) {
        datReposity.save(datos);
         }
}
