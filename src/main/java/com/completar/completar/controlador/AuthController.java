package com.completar.completar.controlador;

import com.completar.completar.modelo.Inicio;
import com.completar.completar.service.IInicioService;
import com.completar.completar.jwt.JWTUtil;
import java.util.List;
import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  
    @Autowired
    private JWTUtil jwtUtil;
    
    @Autowired
    private IInicioService iniService;
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Inicio ini) {

        Inicio usuarioLogueado = iniService.buscarInicio(ini);
        if (usuarioLogueado != null) {
            String tokenJwt =jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getMail());
            return ResponseEntity.ok(new jwtAuthToken(tokenJwt));
             //return new ResponseEntity<>(tokenJwt, HttpStatus.OK);
        }
        //return null;
        //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return (ResponseEntity<?>) ResponseEntity.EMPTY;
    }

    private static class jwtAuthToken {
        private String tokenJwt;

        public jwtAuthToken(String tokenJwt) {
            this.tokenJwt=tokenJwt;
        }
        public String getToken() {
        return tokenJwt;
        }
        public void setToken(String tokenJwt) {
        this.tokenJwt=tokenJwt;
        }
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping ("api/usuario")
    @ResponseBody
    public List<Inicio> verInicio() {
        return iniService.getInicio();
    }
    @CrossOrigin(origins = "*")
    @PostMapping ("api/inicio")
    public void nuevoInicio(@RequestBody Inicio ini) {
       iniService.nuevoInicio(ini);       
    }   
}

       

