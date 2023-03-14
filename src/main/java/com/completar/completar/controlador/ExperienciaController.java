package com.completar.completar.controlador;

import com.completar.completar.jwt.JWTUtil;
import com.completar.completar.modelo.Experiencia;
import com.completar.completar.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ExperienciaController {
    
    @Autowired
private JWTUtil jwtUtil;
    
//Educacion CRUD
   @Autowired 
   private IExperienciaService expExperiencia;
    
   //Listado para CV
@CrossOrigin(origins = "*")      
@GetMapping ("api/experiencia")
public List<Experiencia> getExperiencia() {
    return expExperiencia.getExperiencia();
    }  

@CrossOrigin(origins = "*")
@GetMapping ("api/experiencia/{id}")
public Experiencia getExperienciaxid(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if (!jwtUtil.validateToken(token)) {           
        return null; } else {
        return expExperiencia.buscarExperiencia(id);}
    }
    @CrossOrigin(origins = "*")
    @PostMapping ("api/experiencia/nuevo")
    public void nuevoExperiencia(@RequestHeader(value="Authorization") String token,@RequestBody Experiencia exp) {
        if (!jwtUtil.validateToken(token)) {             
        } else {    
        expExperiencia.nuevoExperiencia(exp);}
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("api/experiencia/delete/{id}")
    public void borrarExperiencia(@RequestHeader(value="Authorization") String token,@PathVariable Long id){
        if (!jwtUtil.validateToken(token)) {             
        } else {
        expExperiencia.borrarExperiencia(id);}
    }       
    
    @CrossOrigin(origins = "*")
    @PutMapping ("api/experiencia/edit/{id}")
    public void editarExperiencia(@RequestHeader(value="Authorization") String token, @PathVariable Long id, @RequestBody Experiencia exp) {
        if (!jwtUtil.validateToken(token)) {             
        } else {
        Experiencia expEdit = expExperiencia.buscarExperiencia(id);
        expEdit.setEmpresa(exp.getEmpresa());
        expEdit.setFecha(exp.getFecha());
        expEdit.setFin(exp.getFin());
        expEdit.setDescripcion(exp.getDescripcion());
        
        expExperiencia.editarExperiencia(exp);}
    }  
    
}
