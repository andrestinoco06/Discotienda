/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author johan
 */
public class Cancion implements Serializable {
    
    private int id;
    private int idDisco;
    private String nombreDisco;
    private int duracionCancion;
    private String fechaPublicacion;
    private String genero;
    private long precio;

    public Cancion(int id, int idDisco, String nombreDisco, int duracionCancion, String fechaPublicacion, String genero, long precio) {
        this.id = id;
        this.idDisco = idDisco;
        this.nombreDisco = nombreDisco;
        this.duracionCancion = duracionCancion;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.precio = precio;
    }

    public long getPrecion() {
        return precio;
    }

    public void setPrecion(long precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public int getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(int duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
}
