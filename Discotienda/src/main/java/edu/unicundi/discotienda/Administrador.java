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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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
    private List<Disco> listaDiscos;

    public Administrador(){
        
    }
    
    @Inject
    private ServiceArtista serviceArtista;
    
    @Inject
    private ServiceDisco serviceDisco;
    
    
    @PostConstruct
    public void init() {
        this.listaArtista = serviceArtista.getListaArtista();
        this.listaDiscos = serviceDisco.getListaDiscos();
    }
    
    public void crearArchivos(){
        new lecturaEscrituraArtista().crearArchivo();
        new lecturaEscrituraDisco().crearArchivo();
    }
    
    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }

    public List<Disco> getListaDiscos() {
        return listaDiscos;
    }

    public void setListaDiscos(List<Disco> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }
}