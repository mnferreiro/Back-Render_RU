package com.completar.completar.controlador;
import com.completar.completar.jwt.JWTUtil;
import com.completar.completar.modelo.Educacion;
import com.completar.completar.service.IEducacionService;
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
public class EducacionController {
     
@Autowired
private JWTUtil jwtUtil;
    
//Educacion CRUD
@Autowired
private IEducacionService interEducacion;

//Listado para CV
@CrossOrigin(origins = "*")      
@GetMapping ("api/educacion")
public List<Educacion> getEducacion() {
    return interEducacion.getEducacion();
    }  

@CrossOrigin(origins = "*")
@GetMapping ("api/educacion/{id}")
public Educacion getEducacionxid(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if (!jwtUtil.validateToken(token)) {           
        return null; } else {
        return interEducacion.buscarEducacion(id);}
    }
    @CrossOrigin(origins = "*")
    @PostMapping ("api/educacion/nuevo")
    public void nuevoEducacion(@RequestHeader(value="Authorization") String token,@RequestBody Educacion edu) {
        if (!jwtUtil.validateToken(token)) {             
        } else {    
        interEducacion.nuevoEducacion(edu);}
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("api/educacion/delete/{id}")
    public void borrarEducacion (@RequestHeader(value="Authorization") String token,@PathVariable Long id){
        if (!jwtUtil.validateToken(token)) {             
        } else {
        interEducacion.borrarEducacion(id);}
    }       
    
    @CrossOrigin(origins = "*")
    @PutMapping ("api/educacion/edit/{id}")
    public void editarEducacion(@RequestHeader(value="Authorization") String token, @PathVariable Long id, @RequestBody Educacion edu) {
        if (!jwtUtil.validateToken(token)) {             
        } else {
        Educacion eduEdit = interEducacion.buscarEducacion(id);
        eduEdit.setTitulo(edu.getTitulo());
        eduEdit.setInstitucion(edu.getInstitucion());
        eduEdit.setFecha(edu.getFecha());
        eduEdit.setFin(edu.getFin());
        
        interEducacion.editarEducacion(edu);}
    }  

}
