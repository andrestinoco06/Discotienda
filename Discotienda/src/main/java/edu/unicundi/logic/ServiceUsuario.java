/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraArtista;
import edu.unicundi.lecturaEscritura.lecturaEscrituraUsuario;
import edu.unicundi.model.Artista;
import edu.unicundi.model.UsuarioModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "serviceUsuario")
@RequestScoped
public class ServiceUsuario {
    
    private List<UsuarioModel> listaUsuario;
    
    public ServiceUsuario(){
        
    }
    
    @PostConstruct
    public void init() {
        
        listaUsuario = new lecturaEscrituraUsuario().verUsuarios();
    }
    
    public boolean validacionUsuario(){
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionAdministrador").equals(true)){
            return true;
        }else{
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }        
    }
    
    public boolean validacionCliente(){
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionCliente").equals(true)){
            return true;
        }else{
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }        
    }
    
    public void agregarUsuario(List<UsuarioModel> listaNuevo){
        new lecturaEscrituraUsuario().agregarUsuario(listaNuevo);
    }
    
    public void crearUsuario(){
        List<UsuarioModel> lista = new ArrayList<>();
        lista.add(new UsuarioModel(1, "Johan", "Zambrano", "prueba@hotmail.com", "cll falsa", "9999", "clave", 22, 1, "3046818117"));
        lista.add(new UsuarioModel(2, "Sebastián", "Páez", "prueba@hotmail.com", "cll falsa", "1111", "clave", 22, 2, "3046818117"));
        try {
            new lecturaEscrituraUsuario().crearArchivo(lista);
        } catch (IOException ex) {
            Logger.getLogger(ServiceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<UsuarioModel> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<UsuarioModel> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

}
