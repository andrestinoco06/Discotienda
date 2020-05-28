/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraCancion;
import edu.unicundi.model.Cancion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ServiceCancion {
    
    List<Cancion> listaCancion;
    
    public ServiceCancion(){
        
    }
    
    @PostConstruct
    public void init() {
        listaCancion = new lecturaEscrituraCancion().verCancion();
    }
    
    public void crearArchicoCancion() throws ParseException{
        List<Cancion> lista = new ArrayList<>();
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
        Date dt_1 = objSDF.parse("20-08-1981"); 
        Date dt_2 = objSDF.parse("12-10-2012");
        lista.add(new Cancion(1,1, "24K Magic", 226,dt_1,"FUNK-", 40000));
        lista.add(new Cancion(2,1, "That's What I Like", 206,dt_1,"FUNK-", 40000));
        lista.add(new Cancion(3,1, "Versace on the Floor", 261, dt_1,"POP-", 40000));
        lista.add(new Cancion(4,3, "La Bicicleta", 227, dt_2, "REGUETON-VALLENATO-", 42000));
        new lecturaEscrituraCancion().crearArchivo(lista);
    }

    public List<Cancion> getListaCancion() {
        return listaCancion;
    }

    public void setListaCancion(List<Cancion> listaCancion) {
        this.listaCancion = listaCancion;
    }

}