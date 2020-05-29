package edu.unicundi.model;

import java.io.Serializable;
import java.util.Date;

/**
 *  Modelo para almacenar los atributos del Disco.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 * @version 1.0.0
 */
public class Disco implements Serializable{
    
    /**
     * Variables String para almacenar los datos genero, nombreDisco.
     */
    private String genero, nombreDisco;
    
    /**
     * Variables int para almacenar los datos id, idArtista.
     */
    private int id, idArtista;
    
    /**
     * Variables long para almacenar los datos precio, duracion.
     */
    private long precio, duracion;
    
    /**
     * Variable Date para almacenar la fechaPublicacion del Disco.
     */
    private Date fechaPublicacion;


    /**
     * Constructor para inicializar los datos de la clase Disco.
     * @param id
     * @param idArtista
     * @param precio
     * @param fechaPublicacion
     * @param genero
     * @param duracion
     * @param nombreDisco 
     */
    public Disco(int id, int idArtista, long precio, Date fechaPublicacion, String genero, long duracion, String nombreDisco) {
        this.id = id;
        this.idArtista = idArtista;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.duracion = duracion;
        this.nombreDisco = nombreDisco;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }   
}