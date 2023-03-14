package com.completar.completar.controlador;

import com.completar.completar.jwt.JWTUtil;
import com.completar.completar.modelo.Testimonio;
import com.completar.completar.service.ITestimonioService;
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
public class TestimoniosController {
    
    @Autowired
private JWTUtil jwtUtil;
    
//Educacion CRUD
@Autowired
private ITestimonioService testiTestimonio;

//Listado para CV
@CrossOrigin(origins = "*")      
@GetMapping ("api/testimonio")
public List<Testimonio> getTestimonio() {
    return testiTestimonio.getTestimonio();
    }  

@CrossOrigin(origins = "*")
@GetMapping ("api/testimonio/{id}")
public Testimonio getTestimonioxid(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if (!jwtUtil.validateToken(token)) {           
        return null; } else {
        return testiTestimonio.buscarTestimonio(id);}
    }
    @CrossOrigin(origins = "*")
    @PostMapping ("api/testimonio/nuevo")
    public void nuevoTestimonio(@RequestHeader(value="Authorization") String token,@RequestBody Testimonio testi) {
        if (!jwtUtil.validateToken(token)) {             
        } else {    
        testiTestimonio.nuevoTestimonio(testi);}
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("api/testimonio/delete/{id}")
    public void borrarTestimonio (@RequestHeader(value="Authorization") String token,@PathVariable Long id){
        if (!jwtUtil.validateToken(token)) {             
        } else {
        testiTestimonio.borrarTestimonio(id);}
    }       
    
    @CrossOrigin(origins = "*")
    @PutMapping ("api/testimonio/edit/{id}")
    public void editarTestimonio(@RequestHeader(value="Authorization") String token, @PathVariable Long id, @RequestBody Testimonio testi) {
        if (!jwtUtil.validateToken(token)) {             
        } else {
        Testimonio testiEdit = testiTestimonio.buscarTestimonio(id);
        testiEdit.setNombre(testi.getNombre());
        testiEdit.setCargo(testi.getCargo());
        testiEdit.setDescripcion(testi.getDescripcion());
                
        testiTestimonio.editarTestimonio(testi);}
    }    
}
