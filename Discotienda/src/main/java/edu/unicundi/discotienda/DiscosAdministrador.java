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
 * Bean para procesar las acciones que se esten realizando en su correspondiente vista.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 * @version 1.0.0
 */
@Named(value = "discosAdministrador")
@ViewScoped 
public class DiscosAdministrador implements Serializable{
    
    /**
     * List de tipo Disco para almacenar los Discos registrados.
     */
    private List<Disco> listaDisco;
    
    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceDisco.
     */
    @Inject
    private ServiceDisco serviceDisco;
    
    
    /**
     * PostConstructor para obtener la lista de Discos.
     */
    @PostConstruct
    public void init() {
        this.listaDisco = serviceDisco.getListaDiscos();
    }

    /**
     * Método para ver más Discos según el artista seleccionado.
     * @param disco 
     */
    public void verMasDisco(Disco disco){
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idDisco", disco.getId());
            FacesContext.getCurrentInstance().getExternalContext().redirect("cancionesDiscoAdmin.xhtml");
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