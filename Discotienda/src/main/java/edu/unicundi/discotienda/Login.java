/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceBusquedaCompra;
import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.logic.ServiceCancion;
import edu.unicundi.logic.ServiceUsuario;
import edu.unicundi.model.UsuarioModel;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "login")
@RequestScoped 
public class Login implements Serializable{
    
    private String usuario, clave, titulo;
    
    @PostConstruct
    public void init() {
        System.out.println("entro al post del login");
        this.titulo = "Iniciar Sesión";
    }
    
    @Inject
    private ServiceArtista serviceArtista;
    @Inject
    private ServiceDisco serviceDisco;
    @Inject
    private ServiceCancion serviceCancion;
    @Inject
    private ServiceUsuario serviceUsuario;
    @Inject
    private ServiceBusquedaCompra serviceBusquedaCompra;
    
    public void iniciarSesion(){
        List<UsuarioModel> listaUsuario = serviceUsuario.getListaUsuario();
        for(int i=0;i<listaUsuario.size();i++){
            if(listaUsuario.get(i).getDocumento().equals(usuario)){
                if(listaUsuario.get(i).getContrasena().equals(clave)){
                    if(listaUsuario.get(i).getIdRol() == 1){
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionAdministrador", true);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSessionAdministrador", listaUsuario.get(i).getId());
                        try {
                            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/artistasAdministrador.xhtml");
                        } catch (IOException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionCliente", true);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSessionCliente", listaUsuario.get(i).getId());
                        try {
                            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/bienvenidaCliente.xhtml");
                        } catch (IOException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }
    
    public void crearArchivos(){
        System.out.println("entro al metodo crearARCHIVOS -------- login");
        try {
            serviceArtista.crearArtista();
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("entro al metodo crearARCHIVOS -------- login2");
        serviceDisco.crearArchicoDisco();
        System.out.println("entro al metodo crearARCHIVOS -------- login3");
        serviceCancion.crearArchicoCancion();
        System.out.println("entro al metodo crearARCHIVOS -------- login4");
        serviceUsuario.crearUsuario();
        System.out.println("entro al metodo crearARCHIVOS -------- login5");
        serviceBusquedaCompra.crearArchivoCarro();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
