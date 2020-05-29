/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Modelo para almacenar los atributos de Artista
 * @author Camilo Tinoco
 * @author Johan Zambrano
 */
public class Artista implements Serializable {
    
    /**
     * Variables tipo String para almacenar los datos nombreArtistico, nombreNacimiento y genero del Artista.
     */
    private String nombreArtistico, nombreNacimiento, genero;
    
    /**
     * Variable tipo int para almacenar el dato id del Artista.
     */
    private int id;
    
    /**
     * Variable tipo Date para almacenar el dato fechaNacimiento del Artista.
     */
    private Date fechaNacimiento;

    /**
     * Constructor para inicializar los atributos de Artista
     * @param id
     * @param nombreArtistico
     * @param nombreNacimiento
     * @param genero
     * @param fechaNacimiento 
     */
    public Artista(int id, String nombreArtistico, String nombreNacimiento, String genero, Date fechaNacimiento) {
        this.id = id;
        this.nombreArtistico = nombreArtistico;
        this.nombreNacimiento = nombreNacimiento;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getNombreNacimiento() {
        return nombreNacimiento;
    }

    public void setNombreNacimiento(String nombreNacimiento) {
        this.nombreNacimiento = nombreNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
   
}