/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceUsuario;
import edu.unicundi.model.UsuarioModel;
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
@Named(value = "interfaceAdmin")
@ViewScoped
public class InterfaceAdmin implements Serializable {

    private String nombre;

    @Inject
    private ServiceUsuario serviceUsuario;

    @PostConstruct
    public void init() {
        if (serviceUsuario.validacionUsuario()) {
            System.out.println("entro al post de interface");
            int id = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionAdministrador");
            System.out.println("--- " + id);
            List<UsuarioModel> lista = serviceUsuario.getListaUsuario();
            System.out.println(" -- " + lista.get(id).getId() + " --- " + id);
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    System.out.println("encontro en el post de interface");
                    nombre = lista.get(id).getNombre() + lista.get(id).getApellido();
                }
            }
        }
    }

    public void cerrarSessionAdmin() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionAdministrador", false);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSessionAdministrador", null);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public void registrarArtistas() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("artistasAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verDiscos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("discosAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verCanciones() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cancionesAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
