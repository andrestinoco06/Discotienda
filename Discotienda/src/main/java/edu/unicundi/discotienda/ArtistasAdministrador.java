package edu.unicundi.discotienda;

import edu.unicundi.lecturaEscritura.lecturaEscrituraArtista;
import edu.unicundi.lecturaEscritura.lecturaEscrituraDisco;
import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.logic.ServiceUsuario;
import edu.unicundi.model.Artista;
import edu.unicundi.model.Disco;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean para procesar las acciones que se esten realizando en la vista ArtistasAdministrador
 * @author Johan Zambrano,
 * @author Camilo Tinoco
 */
@Named(value = "administrador")
@ViewScoped 
public class ArtistasAdministrador implements Serializable{
    
    /**
    * Variable de tipo Artistas que va a ir almacenando la lista de los artistas traida desde los archivos y la muestra
    * en el datatable de la vista
    */
    private List<Artista> listaArtista;
    
    /**
    * Variable de tipo id que almacena el Id
    */
    private int id;
    
    /**
    * Variable de tipo String que almacena el nombre de nacimiento del artista
    */
    private String nombreNacimiento;
    
    /**
    * Variable de tipo String que almacena el nombre artístico 
    */
    private String nombreArtistico;
    
    /**
    * Variable de tipo Array de String que almacena el genero del artista
    */
    private String[] genero;
    
    /**
    * Variable de tipo Date que guarda la fecha de nacimiento del artista
    */
    private Date fechaNacimiento;
    
    /**
    * Constructor principal
    */
    public ArtistasAdministrador(){
    }
    
    /**
    * Variable que realiza la injeccion del ServiceArtista
    */
    @Inject
    private ServiceArtista serviceArtista;
    
    /**
    * PostConstructor que guarda la lista de todos los artistas creados
    */
    @PostConstruct
    public void init() {
        this.listaArtista = serviceArtista.getListaArtista();
    }
    
    /**
    * Funcion que redirecciona al usuario a la vista discosArtistasAdmin con el id correspondiente del artista para mostrar sus discos
    */
    public void verDiscosArtista(Artista artista){
        try {
            id = artista.getId();
            //FacesContext.getCurrentInstance().getExternalContext().redirect("discosArtistasAdmin.xhtml?artista="+artista.getId());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idArtista", artista.getId());
            FacesContext.getCurrentInstance().getExternalContext().redirect("discosArtistasAdmin.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * Crea nuevo artista
    */
    public void crearNuevoArtista(){
        String generoA = "";
        for(int i=0;i<genero.length;i++){
            generoA = generoA+genero[i];
        }        
        listaArtista.add(new Artista(listaArtista.size()+1, nombreArtistico, nombreNacimiento, generoA, fechaNacimiento));
        new lecturaEscrituraArtista().agregarArtista(listaArtista);
    }
    
    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreNacimiento() {
        return nombreNacimiento;
    }

    public void setNombreNacimiento(String nombreNacimiento) {
        this.nombreNacimiento = nombreNacimiento;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ServiceArtista getServiceArtista() {
        return serviceArtista;
    }

    public void setServiceArtista(ServiceArtista serviceArtista) {
        this.serviceArtista = serviceArtista;
    }

    public String[] getGenero() {
        return genero;
    }

    public void setGenero(String[] genero) {
        this.genero = genero;
    }
    
    
}