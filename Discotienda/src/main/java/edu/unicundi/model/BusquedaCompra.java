/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.model;

import java.io.Serializable;

/**
 * Modelo para almacenar los atributos de BusquedaCompra
 * @author Camilo Tinoco
 * @author Johan Zambrano
 */
public class BusquedaCompra implements Serializable{
    
    /**
     * Variables tipo String para almacenar los datos nombreArtista, nombreDisco, nombreCancion, genero, tipo del Disco.
     */
    private String nombreArtista, nombreDisco, nombreCancion, genero, tipo;
    
    /**
     * Variables tipo int para almacenar los datos id, idDisco, idCancion, idUsuario del Disco.
     */
    private int id, idDisco, idCancion, idUsuario;
    
    /**
     * Variables tipo long para almacenar los datos duracion y precio del Disco.
     */
    private long duracion, precio;

    /**
     * Constructor para inicializar los atributos de la clase BusquedaCompra.
     * @param id
     * @param nombreArtista
     * @param nombreDisco
     * @param nombreCancion
     * @param genero
     * @param duracion
     * @param precio
     * @param tipo
     * @param idDisco
     * @param idCancion
     * @param idUsuario 
     */
    public BusquedaCompra(int id, String nombreArtista, String nombreDisco, String nombreCancion, String genero, long duracion, long precio, String tipo, int idDisco, int idCancion, int idUsuario) {
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
        this.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}