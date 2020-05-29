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
 * Bean para procesar las acciones que se esten realizando en la vista CancionesAdministrador
 * @author Johan Zambrano
 * @author Camilo tinoco
 */
@Named(value = "cancionesAdministrador")
@ViewScoped 
public class CancionesAdministrador implements Serializable{
    
    /**
    * Guarda la lista de todas las canciones
    */
    private List<Cancion> listaCancion;
    
    /**
    * Constructor vacio
    */
    public CancionesAdministrador (){
        
    }
    
    /**
    * Variable que realiza la injeccion al ServiceCancion
    */
    @Inject
    private ServiceCancion serviceCancion;
    
    /**
    *PostConstructor que realiza la busqueda de todas las canciones que pertenecen al disco
    */
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
    /*
    * Funcion que redirecciona la vista
    */
    public void verMasCancion(Cancion cancion){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("informacionAdicional.xhtml?informacion="+cancion.getId()+"&tipo="+2);
        } catch (IOException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}