package com.completar.completar.controlador;
import com.completar.completar.jwt.JWTUtil;
import com.completar.completar.modelo.Datos;
import com.completar.completar.modelo.Experiencia;
import com.completar.completar.modelo.Formulario;
import com.completar.completar.modelo.Inicio;
import com.completar.completar.modelo.Servicios;
import com.completar.completar.modelo.Skins;
import com.completar.completar.modelo.Testimonio;
import com.completar.completar.service.IDatosService;
import com.completar.completar.service.IExperienciaService;
import com.completar.completar.service.IFormularioService;
import com.completar.completar.service.IInicioService;
import com.completar.completar.service.IServiciosService;
import com.completar.completar.service.ISkinsService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SkinsController {   
    @Autowired
    private JWTUtil jwtUtil;
    
    //Skins
    @Autowired
    private ISkinsService interSkins;
    @CrossOrigin(origins = "*")
    @GetMapping ("api/skins")
    public List<Skins> getSkins() {
        return interSkins.getSkins();
    }
    @CrossOrigin(origins = "*")
    @GetMapping ("api/skins/{id}")
    public Skins getSkinsxid(@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        if (!jwtUtil.validateToken(token)) {           
        return null; } else {
        return interSkins.buscarSkins(id);}
    }
    @CrossOrigin(origins = "*")
    @PostMapping ("api/skins/nuevo")
    public void nuevoSkins(@RequestHeader(value="Authorization") String token,@RequestBody Skins ski) {
        if (!jwtUtil.validateToken(token)) {             
        } else {    
        interSkins.nuevoSkins(ski);}
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("api/skins/delete/{id}")
    public void borrarSkins (@RequestHeader(value="Authorization") String token,@PathVariable Long id){
        if (!jwtUtil.validateToken(token)) {             
        } else {
        interSkins.borrarSkins(id);}
    }       
    
    @CrossOrigin(origins = "*")
    @PutMapping ("api/skins/edit/{id}")
    public void editarSkins(@RequestHeader(value="Authorization") String token, @PathVariable Long id, @RequestBody Skins ski) {
        if (!jwtUtil.validateToken(token)) {             
        } else {
        Skins skinsEdit = interSkins.buscarSkins(id);
        skinsEdit.setNombre(ski.getNombre());
        skinsEdit.setValor(ski.getValor());
        interSkins.editarSkins(ski); }
    }  
       
    
    //Formulario Contacto
    @Autowired
    private IFormularioService forSer;
    @CrossOrigin(origins = "*")
    @PostMapping ("api/formulario")
    public void nuevoContacto(@RequestBody Formulario formu) {
        forSer.nuevoFormulario(formu);
    }
    @CrossOrigin(origins = "*")
    @GetMapping ("api/mensajes")
    @ResponseBody
    public List<Formulario> verMensajes() {
        return forSer.getFormulario();
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("api/delete/{id}")
    public void borrarMensaje (@RequestHeader(value="Authorization") String token, @PathVariable Long id) {
        //le pido token para autorizar delete      
         if (!jwtUtil.validateToken(token)) {             
        } else {
        forSer.borrarFormulario(id);   }     
    }                
      
   
    }

  
       
        

