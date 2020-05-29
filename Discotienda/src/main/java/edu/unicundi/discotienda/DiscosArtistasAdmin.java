package edu.unicundi.discotienda;

import edu.unicundi.lecturaEscritura.lecturaEscrituraDisco;
import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.model.Disco;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
 * Bean para procesar las acciones que se esten realizando en su correspondiente vista.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 * @version 1.0.0
 */
@Named(value = "discosArAd")
@ViewScoped
public class DiscosArtistasAdmin implements Serializable {

    /**
     * Variables de tipo String para almacenar los datos del nombreDisco del Disco.
     */
    private String nombreDisco;
    
    /**
     * Variables de tipo int para almacenar los datos idArtista y duracion del Disco.
     */
    private int idArtista, duracion;
    
    /**
     * Variable de tipo Date para almacenar las fechaPublicacion del Disco.
     */
    private Date fechaPublicacion;
    
    /**
     * Variable de tipo long para almacenar el precio del Disco.
     */
    private long precio;
    
    /**
     * Variable Array de String para almacenar los generos del Disco.
     */
    private String[] genero;

    /**
     * List de tipo Disco para almacenar los Discos registrados.
     */
    private List<Disco> listaDiscos;

    /**
     * Constructor de prueba.
     */
    public DiscosArtistasAdmin() {
        System.out.println(" -  - -- - - entro al constructor DISCOS ");
    }

    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceDisco.
     */
    @Inject
    private ServiceDisco serviceDisco;

    /**
     * PostConstructor para cargar los Discos en la vista.
     */
    @PostConstruct
    public void init() {
        cargarDiscos();
    }

    /**
     * Método para ver las canciones del Disco.
     * @param discos 
     */
    public void verCancionesDiscos(Disco discos) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idDisco", discos.getId());
            FacesContext.getCurrentInstance().getExternalContext().redirect("cancionesDiscoAdmin.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para almacenar las canciones registradas en la lista para posteriormente su visualizacion.
     */
    public void cargarDiscos() {
        if (!FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idArtista").equals(null)) {
            idArtista = (int) (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idArtista"));
            System.out.println(" -  - -- - - " + idArtista);
            this.listaDiscos = serviceDisco.getListaDiscos();
            List<Disco> listaBusqueda = new ArrayList<>();
            for (int i = 0; i < listaDiscos.size(); i++) {
                if (listaDiscos.get(i).getIdArtista() == idArtista) {
                    listaBusqueda.add(listaDiscos.get(i));
                }
            }
            listaDiscos = listaBusqueda;
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("artistasAdministrador.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(DiscosArtistasAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método para crear un nuevo Disco.
     */
    public void crearNuevoDisco() {
        System.out.println(" antes de añadir ");
        List<Disco> totalDiscos = new ArrayList<>();
        totalDiscos = serviceDisco.getListaDiscos();
        System.out.println(" antes de añadir " + totalDiscos.size());
        String generoA = "";
        for (int i = 0; i < genero.length; i++) {
            generoA = generoA + genero[i];
        }

        
        totalDiscos.add(new Disco(totalDiscos.size() + 1, idArtista, precio, fechaPublicacion, generoA, duracion, nombreDisco));
        new lecturaEscrituraDisco().agregarDisco(totalDiscos);
        cargarDiscos();
    }

    public List<Disco> getListaDiscos() {
        return listaDiscos;
    }

    public void setListaDiscos(List<Disco> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String[] getGenero() {
        return genero;
    }

    public void setGenero(String[] genero) {
        this.genero = genero;
    }

}
