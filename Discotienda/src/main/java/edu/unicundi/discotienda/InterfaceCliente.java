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
@Named(value = "interfaceCliente")
@ViewScoped
public class InterfaceCliente implements Serializable {

    private String nombre;

    @Inject
    private ServiceUsuario serviceUsuario;

    @PostConstruct
    public void init() {
        if (serviceUsuario.validacionCliente()) {
            int id = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionCliente");
            List<UsuarioModel> lista = serviceUsuario.getListaUsuario();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    nombre = lista.get(i).getNombre() + " " + lista.get(i).getApellido();
                }
            }
        }
    }

    public void inicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("bienvenidaCliente.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comprar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("compra.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carrito() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("carrito.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionCliente", false);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSessionCliente", null);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void historialDeCompras() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("historialCompraUsuario.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
