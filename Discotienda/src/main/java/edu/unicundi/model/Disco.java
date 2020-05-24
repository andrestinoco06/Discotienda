/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.model;

import java.util.Date;

/**
 *
 * @author johan
 */
public class Disco {
    
    private int id;
    private int idArtista;
    private long precio;
    private Date fechaPublicacion;
    private int[] genero;
    private long duracion;

    public Disco(int id, int idArtista, long precio, Date fechaPublicacion, int[] genero, long duracion) {
        this.id = id;
        this.idArtista = idArtista;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.duracion = duracion;
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

    public int[] getGenero() {
        return genero;
    }

    public void setGenero(int[] genero) {
        this.genero = genero;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }
    
    
    
}
