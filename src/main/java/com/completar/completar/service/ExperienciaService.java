
package com.completar.completar.service;

import com.completar.completar.modelo.Experiencia;
import com.completar.completar.repository.experienciaReposity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

@Service
public class ExperienciaService implements IExperienciaService{
   @Autowired
    private experienciaReposity expReposity;
    
    @Override
    public List<Experiencia> getExperiencia () {
        List<Experiencia> listaExperiencia = expReposity.findAll(Sort.by(Sort.Direction.DESC, "fecha"));
        return listaExperiencia; 
}
@Override
    public void nuevoExperiencia(Experiencia exp) {
        expReposity.save(exp);
        }

    @Override
    public void borrarExperiencia(Long id) {
        expReposity.deleteById(id);
         }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return expReposity.findById(id).orElse(null);
         }

    @Override
    public void editarExperiencia(Experiencia exp) {
        expReposity.save(exp);
          }
}



    
 
