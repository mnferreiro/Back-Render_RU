
package com.completar.completar.service;

import com.completar.completar.modelo.Servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.completar.completar.repository.serviciosReposity;

@Service
public class ServiciosService implements IServiciosService{
    @Autowired
    private serviciosReposity serviciosService;
    
    @Override
    public List<Servicios> getServicios () {
        List<Servicios> listaServicios = serviciosService.findAll();
        return listaServicios; 
}
    @Override
    public void nuevoServicios(Servicios servi) {
    serviciosService.save(servi);
    }

    @Override
    public void borrarServicios(Long id) {
       serviciosService.deleteById(id);
    }

    @Override
    public Servicios buscarServicios(Long id) {
       return serviciosService.findById(id).orElse(null);
               }

    @Override
    public void editarServicios(Servicios servi) {
    serviciosService.save(servi);
    }
}
