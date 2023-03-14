
package com.completar.completar.service;

import com.completar.completar.modelo.Inicio;
import com.completar.completar.repository.inicioReposity;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InicioService implements IInicioService{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private inicioReposity iniReposity;
        
  
    @Override
    public List<Inicio> getInicio() {
        return iniReposity.findAll();
    }

    @Override
    public void nuevoInicio(Inicio ini) {
        iniReposity.save(ini);
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, ini.getContraseña());
        ini.setContraseña(hash);
    }

    @Override
    public void borrarInicio(Long id) {
        iniReposity.deleteById(id); ;
                              
    }
//@Deprecated
    @Override
    public Inicio buscarInicio(Inicio ini) {
        String query = "FROM Inicio WHERE mail = :mail";
        List<Inicio> lista = entityManager.createQuery(query).setParameter("mail", ini.getMail()).getResultList();
        if (lista.isEmpty()) {
            return null;
        }
        
        String passwordHashed = lista.get(0).getContraseña();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, ini.getContraseña())) {
            return lista.get(0);
        }
        return null;    
    }

    
}
