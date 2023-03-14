
package com.completar.completar.service;

import com.completar.completar.modelo.Skins;
import java.util.List;


public interface ISkinsService {
    public List<Skins> getSkins ();
    
    public void nuevoSkins(Skins ski);
    
    public void borrarSkins (Long id);
    
    public Skins buscarSkins (Long id);
    
    public void editarSkins (Skins ski);
}
