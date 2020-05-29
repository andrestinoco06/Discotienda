/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.model;

import java.io.Serializable;

/**
 *
 * @author johan
 */
public class BusquedaCompra implements Serializable{
    
    private int id, idDisco, idCancion;
    private String nombreArtista, nombreDisco, nombreCancion, genero, tipo;
    private long duracion, precio;

    public BusquedaCompra(int id, String nombreArtista, String nombreDisco, String nombreCancion, String genero, long duracion, long precio, String tipo, int idDisco, int idCancion) {
        this.id = id;
        this.nombreArtista = nombreArtista;
        this.nombreDisco = nombreDisco;
        this.nombreCancion = nombreCancion;
        this.genero = genero;
        this.duracion = duracion;
        this.precio = precio;
        this.tipo = tipo;
        this.idDisco = idDisco;
        this.idCancion = idCancion;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
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

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }
}