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
@Named(value = "serviceArtista")
@RequestScoped
public class ServiceArtista {
    
    private List<Artista> listaArtista;
    
    public ServiceArtista(){
        
    }
    
    @PostConstruct
    public void init() {
        System.out.println(" entro al POSTconstructor SERVICE");
        
        listaArtista = new lecturaEscrituraArtista().verArtistas();
    }
    
    public void crearArtista(){
        System.out.println(" entro al METODO CREAR ARTISTA ");
        List<Artista> lista = new ArrayList<>();
        lista.add(new Artista(1, "Bruno Mars", "Peter Gene Hernandez", "POP-FUNK", "10-08-1985"));
        lista.add(new Artista(2, "Shakira", "Shakira Isabel Mebarak Ripoll", "POP-ROCK EN ESPAÑOL", "02-02-1977"));
        lista.add(new Artista(3, "Elvis Presley", "Elvis Aaron Presley", "POP-ROCK-COUNTRY", "08-01-1935"));
        lista.add(new Artista(4, "Redimi2", "Willy González Cruz", "HIP HOP CRISTIANO-RAP-TRAP", "03-06-1979"));
        new lecturaEscrituraArtista().crearArchivo(lista);
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }
    
    
    
}
