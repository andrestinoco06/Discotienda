/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceCancion;
import edu.unicundi.model.Cancion;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "cancionesAdministrador")
@ViewScoped 
public class CancionesAdministrador implements Serializable{
    
    private List<Cancion> listaCancion;
    
    public CancionesAdministrador (){
        
    }
    
    @Inject
    private ServiceCancion serviceCancion;
    
    @PostConstruct
    public void init() {
        this.listaCancion = serviceCancion.getListaCancion();
    }

    public List<Cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Cancion> listaCancion) {
        this.listaCancion = listaCancion;
    }
    
    public void verMasCancion(Cancion cancion){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("informacionAdicional.xhtml?informacion="+cancion.getId()+"&tipo="+2);
        } catch (IOException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}