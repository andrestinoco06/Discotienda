/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author johan
 */
@Named(value = "discosArAd")
@ViewScoped
public class DiscosArtistasAdmin implements Serializable {

    private int idArtista;
    private String nombreDisco;
    private Date fechaPublicacion;
    private long precio;
    private int duracion;
    private String[] genero;
    
    private List<Disco> listaDiscos;

    public DiscosArtistasAdmin() {
        System.out.println(" -  - -- - - entro al constructor DISCOS ");
    }

    @Inject
    private ServiceDisco serviceDisco;

    @PostConstruct
    public void init() {
        cargarDiscos();
    }

    public void verCancionesDiscos(Disco discos){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cancionesDiscoAdmin.xhtml?disco="+discos.getId());
        } catch (IOException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarDiscos() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map params = externalContext.getRequestParameterMap();
        idArtista = new Integer((String) params.get("artista"));
        System.out.println(" -  - -- - - " + idArtista);
        this.listaDiscos = serviceDisco.getListaDiscos();
        List<Disco> listaBusqueda = new ArrayList<>();
        
        for (int i = 0; i < listaDiscos.size(); i++) {
            if (listaDiscos.get(i).getIdArtista() == idArtista) {
                listaBusqueda.add(listaDiscos.get(i));
            }
        }
        listaDiscos = listaBusqueda;
    }
    
    public void crearNuevoDisco(){
        List<Disco> totalDiscos = new ArrayList<>();
        totalDiscos = serviceDisco.getListaDiscos();
        System.out.println(" antes de añadir "+totalDiscos.size());
        String generoA = "";
        for(int i=0;i<genero.length;i++){
            generoA = generoA+genero[i];
        }        
        
        String fecha = fechaPublicacion.getDay() + "-" + fechaPublicacion.getMonth() + "-" + fechaPublicacion.getYear();
        totalDiscos.add(new Disco(totalDiscos.size()+1,idArtista,precio,fecha,generoA,duracion,nombreDisco));
        System.out.println(" despues de añadir "+totalDiscos.size());
        new lecturaEscrituraDisco().agregarDisco(totalDiscos);
        listaDiscos = totalDiscos;
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
