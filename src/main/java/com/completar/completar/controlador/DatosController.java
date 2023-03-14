package com.completar.completar.controlador;

import com.completar.completar.jwt.JWTUtil;
import com.completar.completar.modelo.Datos;
import com.completar.completar.service.IDatosService;
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

public class DatosController {
    
    @Autowired
  private JWTUtil jwtUtil;
  
  //Datos CRUD
@Autowired
private IDatosService datosDatos;

//Listado para CV
@CrossOrigin(origins = "*")      
@GetMapping ("api/datos")
public List<Datos> getDatos() {
    return datosDatos.getDatos();
    }  

@CrossOrigin(origins = "*")
@GetMapping ("api/datos/{id}")
public Datos getDatosxid(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if (!jwtUtil.validateToken(token)) {           
        return null; } else {
        return datosDatos.buscarDatos(id);}
    }
    @CrossOrigin(origins = "*")
    @PostMapping ("api/datos/nuevo")
    public void nuevoDatos(@RequestHeader(value="Authorization") String token,@RequestBody Datos datos) {
        if (!jwtUtil.validateToken(token)) {             
        } else {    
        datosDatos.nuevoDatos(datos);}
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("api/datos/delete/{id}")
    public void borrarDatos(@RequestHeader(value="Authorization") String token,@PathVariable Long id){
        if (!jwtUtil.validateToken(token)) {             
        } else {
        datosDatos.borrarDatos(id);}
    }       
    
    @CrossOrigin(origins = "*")
    @PutMapping ("api/datos/edit/{id}")
    public void editarDatos(@RequestHeader(value="Authorization") String token, @PathVariable Long id, @RequestBody Datos datos) {
        if (!jwtUtil.validateToken(token)) {             
        } else {
        Datos datosEdit = datosDatos.buscarDatos(id);
        datosEdit.setNombre(datos.getNombre());
        datosEdit.setDireccion(datos.getDireccion());
        datosEdit.setTelefono(datos.getTelefono());
        datosEdit.setMail(datos.getMail());
        datosEdit.setInteres(datos.getInteres());
        datosEdit.setDisponibilidad(datos.getDisponibilidad());
        datosEdit.setEspecialidad(datos.getEspecialidad());
        datosEdit.setObjetivo(datos.getObjetivo());        
        
        datosDatos.editarDatos(datos);}
    }  
    
}
