/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.lecturaEscritura.lecturaEscrituraCancion;
import edu.unicundi.lecturaEscritura.lecturaEscrituraDisco;
import edu.unicundi.logic.ServiceCancion;
import edu.unicundi.model.Cancion;
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
@Named(value = "cancionesDisAdmin")
@ViewScoped
public class CancionesDiscoAdmin implements Serializable {

    private List<Cancion> listaCancion;
    private int idDisco;

    private String nombreCancion;
    private int duracion;
    private String[] genero;
    private Date fechaPublicacion;
    private int precio;

    public CancionesDiscoAdmin() {

    }

    @Inject
    private ServiceCancion serviceCancion;

    @PostConstruct
    public void init() {
        cargarCanciones();
    }

    public void cargarCanciones() {
        if (!FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idDisco").equals(null)) {
            List<Cancion> listaBusqueda = new ArrayList<>();
            idDisco = (int) (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idDisco"));
            this.listaCancion = serviceCancion.getListaCancion();
            for (int i = 0; i < listaCancion.size(); i++) {
                if (listaCancion.get(i).getIdDisco() == idDisco) {
                    listaBusqueda.add(listaCancion.get(i));
                }
            }
            listaCancion = listaBusqueda;
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("artistasAdministrador.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(DiscosArtistasAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void crearNuevaCancion() {
        List<Cancion> totalCanciones = new ArrayList<>();
        totalCanciones = serviceCancion.getListaCancion();
        String generoA = "";
        for (int i = 0; i < genero.length; i++) {
            generoA = generoA + genero[i];
        }
        //String fecha = fechaPublicacion.getDay() + "-" + fechaPublicacion.getMonth() + "-" + fechaPublicacion.getYear();
        String fecha = fechaPublicacion.toString();
        totalCanciones.add(new Cancion(totalCanciones.size() + 1, idDisco, nombreCancion, duracion, fechaPublicacion, generoA, precio));
        new lecturaEscrituraCancion().agregarCancion(listaCancion);
        listaCancion = totalCanciones;
    }

    public List<Cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Cancion> listaCancion) {
        this.listaCancion = listaCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
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

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
