/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.model.Disco;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "discosAdministrador")
@ViewScoped 
public class DiscosAdministrador implements Serializable{
    
    private List<Disco> listaDisco;
    
    @Inject
    private ServiceDisco serviceDisco;
    
    @PostConstruct
    public void init() {
        this.listaDisco = serviceDisco.getListaDiscos();
    }

    public void verMasDisco(Disco disco){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cancionesDiscoAdmin.xhtml?disco="+disco.getId());
        } catch (IOException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Disco> getListaDisco() {
        return listaDisco;
    }

    public void setListaDisco(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }
    
}