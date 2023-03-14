package com.completar.completar.controlador;

import com.completar.completar.jwt.JWTUtil;
import com.completar.completar.modelo.Servicios;
import com.completar.completar.service.IServiciosService;
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

public class ServiciosController {
    
    @Autowired
private JWTUtil jwtUtil;
    
//Educacion CRUD
   @Autowired
   private IServiciosService serviServicios;
   
   //Listado para CV
@CrossOrigin(origins = "*")      
@GetMapping ("api/servicios")
public List<Servicios> getServicios() {
    return serviServicios.getServicios();
    }  

@CrossOrigin(origins = "*")
@GetMapping ("api/servicios/{id}")
public Servicios getServiciosxid(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if (!jwtUtil.validateToken(token)) {           
        return null; } else {
        return serviServicios.buscarServicios(id);}
    }
    @CrossOrigin(origins = "*")
    @PostMapping ("api/servicios/nuevo")
    public void nuevoServicios(@RequestHeader(value="Authorization") String token,@RequestBody Servicios servi) {
        if (!jwtUtil.validateToken(token)) {             
        } else {    
        serviServicios.nuevoServicios(servi);}
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("api/servicios/delete/{id}")
    public void borrarServicios (@RequestHeader(value="Authorization") String token,@PathVariable Long id){
        if (!jwtUtil.validateToken(token)) {             
        } else {
        serviServicios.borrarServicios(id);}
    }       
    
    @CrossOrigin(origins = "*")
    @PutMapping ("api/servicios/edit/{id}")
    public void editarEducacion(@RequestHeader(value="Authorization") String token, @PathVariable Long id, @RequestBody Servicios servi) {
        if (!jwtUtil.validateToken(token)) {             
        } else {
        Servicios serviEdit = serviServicios.buscarServicios(id);
        serviEdit.setIcono(servi.getIcono());
        serviEdit.setNombre(servi.getNombre());
        serviEdit.setDescripcion(servi.getDescripcion());
        
        serviServicios.editarServicios(servi);}
    }  
    
}
