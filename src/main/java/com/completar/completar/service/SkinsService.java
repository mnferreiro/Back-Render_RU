
package com.completar.completar.service;

import com.completar.completar.modelo.Skins;
import com.completar.completar.repository.skinsReposity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkinsService implements ISkinsService{
   @Autowired
    private skinsReposity skiReposity;
    
    @Override
    public List<Skins> getSkins () {
        List<Skins> listaSkins = skiReposity.findAll();
        return listaSkins; 
}
    @Override
    public void nuevoSkins(Skins ski) {
        skiReposity.save(ski);
    }

    @Override
    public void borrarSkins(Long id) {
        skiReposity.deleteById(id);                            
    }
    @Override
    public Skins buscarSkins(Long id) {
        return skiReposity.findById(id).orElse(null);
    }
    @Override
    public void editarSkins(Skins ski) {
        skiReposity.save(ski);
    }
}
