
package com.completar.completar.service;

import com.completar.completar.modelo.Formulario;
import com.completar.completar.repository.formularioReposity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;





@Service
public class FormularioService implements IFormularioService{
    
    @Autowired
    private formularioReposity formuReposity;
        
  
    @Override
    public List<Formulario> getFormulario() {
        return formuReposity.findAll();
    }

    @Override
    public void nuevoFormulario(Formulario formu) {
        formuReposity.save(formu);
    }

    @Override
    public void borrarFormulario(Long id) {
        formuReposity.deleteById(id);
                              
    }

    @Override
    public Formulario buscarFormulario(Long id) {
        return formuReposity.findById(id).orElse(null);
    }
    
    

}
