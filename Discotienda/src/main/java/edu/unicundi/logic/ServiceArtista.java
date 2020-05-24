/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraArtista;
import edu.unicundi.model.Artista;
import edu.unicundi.model.Cancion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "serviceCancion")
@RequestScoped
public class ServiceArtista {
    
    private List<Artista> listaArtista;
    
    public ServiceArtista(){
        listaArtista = new ArrayList<>();
    }
    
    @PostConstruct
    public void init() {
        listaArtista = new lecturaEscrituraArtista().verArtistas();
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }
    
    
    
}
