/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.lecturaEscritura.lecturaEscrituraArtista;
import edu.unicundi.lecturaEscritura.lecturaEscrituraDisco;
import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.model.Artista;
import edu.unicundi.model.Disco;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "administrador")
@SessionScoped 
public class Administrador implements Serializable{
    
    private List<Artista> listaArtista;
    
    private int id;
    private String nombreNacimiento;
    private String nombreArtistico;
    private String[] genero;
    private Date fechaNacimiento;
    
    public Administrador(){
        System.out.println(" entro al constructor ADMIN");
    }
    
    @Inject
    private ServiceArtista serviceArtista;
    
    @PostConstruct
    public void init() {
        System.out.println(" entro al constructor ADMIN");
        this.listaArtista = serviceArtista.getListaArtista();
    }
    
    public void verDiscosArtista(Artista artista){
        try {
            id = artista.getId();
            FacesContext.getCurrentInstance().getExternalContext().redirect("discosArtistasAdmin.xhtml?artista="+artista.getId());
        } catch (IOException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearNuevoArtista(){
        String generoA = "";
        for(int i=0;i<genero.length;i++){
            generoA = genero[i];
        }        
        System.out.println("lista ADMIN "+listaArtista.size());
        listaArtista.add(new Artista(listaArtista.size(), nombreArtistico, nombreNacimiento, generoA, fechaNacimiento.toString()));
        new lecturaEscrituraArtista().agregarArtista(listaArtista);
    }
    
    
    
    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreNacimiento() {
        return nombreNacimiento;
    }

    public void setNombreNacimiento(String nombreNacimiento) {
        this.nombreNacimiento = nombreNacimiento;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ServiceArtista getServiceArtista() {
        return serviceArtista;
    }

    public void setServiceArtista(ServiceArtista serviceArtista) {
        this.serviceArtista = serviceArtista;
    }

    public String[] getGenero() {
        return genero;
    }

    public void setGenero(String[] genero) {
        this.genero = genero;
    }
    
    
}