
package com.completar.completar.service;

import com.completar.completar.modelo.Educacion;
import com.completar.completar.repository.educacionReposity;
import static java.lang.System.console;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

@Service
public class EducacionService implements IEducacionService{
    @Autowired
    private educacionReposity eduReposity;
    
    @Override
    public List<Educacion> getEducacion () {
        List<Educacion> listaEducacion = eduReposity.findAll(Sort.by(Sort.Direction.ASC,"fecha"));
        return listaEducacion;        
    }

    @Override
    public void nuevoEducacion(Educacion edu) {
        eduReposity.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
        eduReposity.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return eduReposity.findById(id).orElse(null);
    }

    @Override
    public void editarEducacion(Educacion edu) {
        eduReposity.save(edu);
        }
}
