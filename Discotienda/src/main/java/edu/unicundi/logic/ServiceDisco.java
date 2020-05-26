/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraDisco;
import edu.unicundi.model.Disco;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "serviceDisco")
@RequestScoped
public class ServiceDisco {
    
    List<Disco> listaDisco;
    
    public ServiceDisco(){
        
    }
    
    @PostConstruct
    public void init() {
        listaDisco = new lecturaEscrituraDisco().verDiscos();
    }
    
    public void crearArchicoDisco(){
        List<Disco> lista = new ArrayList<>();
        lista.add(new Disco(1, 1, 240000, "10-08-1985", "POP-FUNK", 2010, "24K Magic"));
        lista.add(new Disco(2, 1, 270000, "06-12-2012", "POP-FUNK", 2091, "Unorthodox Jukebox"));
        lista.add(new Disco(3, 2, 365000, "26-05-2017", "POP LATINO-REGUETÓN-POP", 2637, "El dorado"));
        lista.add(new Disco(4, 3, 370000, "01-10-1960", "ROCK", 1595, "G.I. Blues"));
        new lecturaEscrituraDisco().crearArchivo(lista);
    }
    
    public List<Disco> getListaDiscos() {
        return listaDisco;
    }

    public void setListaDiscos(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }
}
