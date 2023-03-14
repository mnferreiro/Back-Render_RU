
package com.completar.completar.service;

import com.completar.completar.modelo.Testimonio;
import com.completar.completar.repository.testimonioReposity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestimonioService implements ITestimonioService{
   @Autowired
    private testimonioReposity testimonioReposity;
    
    @Override
    public List<Testimonio> getTestimonio () {
        List<Testimonio> listaTestimonio = testimonioReposity.findAll();
        return listaTestimonio; 
} 
    @Override
    public void nuevoTestimonio(Testimonio testi) {
        testimonioReposity.save(testi);
    }

    @Override
    public void borrarTestimonio(Long id) {
        testimonioReposity.deleteById(id);
    }

    @Override
    public Testimonio buscarTestimonio(Long id) {
        return testimonioReposity.findById(id).orElse(null);
    }

    @Override
    public void editarTestimonio(Testimonio testi) {
        testimonioReposity.save(testi);
        }
}
