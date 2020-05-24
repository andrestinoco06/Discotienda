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
    private long duracionCancion;
    private Date fechaPublicacion;
    private int[] genero;

    public Cancion(int id, int idDisco, String nombreDisco, long duracionCancion, Date fechaPublicacion, int[] genero) {
        this.id = id;
        this.idDisco = idDisco;
        this.nombreDisco = nombreDisco;
        this.duracionCancion = duracionCancion;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
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

    public long getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(long duracionCancion) {
        this.duracionCancion = duracionCancion;
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
    
    
    
}
