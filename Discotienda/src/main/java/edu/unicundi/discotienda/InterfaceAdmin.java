/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "interfaceAdmin")
@ViewScoped 
public class InterfaceAdmin implements Serializable{
    
    public void registrarArtistas(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("artistasAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void verDiscos(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("discosAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verCanciones(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cancionesAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}