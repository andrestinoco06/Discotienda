/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.lecturaEscritura.lecturaEscrituraArtista;
import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.model.Artista;
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

    public Administrador(){
        
    }
    
    public void crearArchivos(){
        
        try {
            new lecturaEscrituraArtista().crearArchivo();
        } catch (ParseException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    @Inject
    private ServiceArtista service;
    
    @PostConstruct
    public void init() {
        this.listaArtista = service.getListaArtista();
    }

    public List<Artista> getLista() {
        return listaArtista;
    }

    public void setLista(List<Artista> lista) {
        this.listaArtista = lista;
    }
    
}
