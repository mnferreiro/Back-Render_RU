
package com.completar.completar.service;

import com.completar.completar.modelo.Testimonio;
import java.util.List;

public interface ITestimonioService {
    public List<Testimonio> getTestimonio ();
    
    public void nuevoTestimonio(Testimonio testi);
    
public void borrarTestimonio (Long id);
    
public Testimonio buscarTestimonio (Long id);
    
public void editarTestimonio (Testimonio testi);
}
