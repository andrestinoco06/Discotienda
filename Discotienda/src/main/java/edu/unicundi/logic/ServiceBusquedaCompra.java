/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraCarrito;
import edu.unicundi.model.Artista;
import edu.unicundi.model.BusquedaCompra;
import edu.unicundi.model.Cancion;
import edu.unicundi.model.Disco;
import edu.unicundi.model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "serviceBusquedaCompra")
@RequestScoped
public class ServiceBusquedaCompra {
    
    private List<BusquedaCompra> listaCompra;
    
    private String nombre, tipo;
    
    public ServiceBusquedaCompra(){
        
    }
    
    @PostConstruct
    public void init() {
        listaCompra = new lecturaEscrituraCarrito().verCarro();
    }
    
    @Inject
    private ServiceArtista serviceArtista;

    @Inject
    private ServiceCancion serviceCancion;

    @Inject
    private ServiceUsuario serviceUsuario;

    @Inject
    private ServiceDisco serviceDisco;
    
    public List<BusquedaCompra> cargarLista(){
        listaCompra = new ArrayList<>();
        listaCompra.add(new BusquedaCompra(-1, "vacio", "vacio", "vacio", "vacio", 0, 0, "vacio", -1));
        return listaCompra;
    }
    
    public void crearArchivoCarro(){
        List<BusquedaCompra> lista = new ArrayList<>();
        new lecturaEscrituraCarrito().agregarCarro(lista);
    }
    
    public List<BusquedaCompra> verCarrito(){
        return new lecturaEscrituraCarrito().verCarro();
    }
    
    public void agregarCarrito(List<BusquedaCompra> agregarCarrito){
        new lecturaEscrituraCarrito().agregarCarro(agregarCarrito);
    }
    
    public List<BusquedaCompra> realizarBusqueda(String nombre, String tipo){
        listaCompra = new ArrayList<>();
        if (tipo.equals("1")) {
            List<Artista> listaUsuario = serviceArtista.getListaArtista();
            for (int i = 0; i < listaUsuario.size(); i++) {
                if(listaUsuario.get(i).getNombreArtistico().contains(nombre)){
                    List<Disco> listaDisco = serviceDisco.getListaDiscos();
                    for(int q=0;q<listaDisco.size();q++){
                        if(listaDisco.get(q).getIdArtista()==listaUsuario.get(i).getId()){
                            listaCompra.add(new BusquedaCompra(listaDisco.get(i).getId(), listaUsuario.get(i).getNombreArtistico(), listaDisco.get(q).getNombreDisco(), "no aplica", listaDisco.get(q).getGenero(), listaDisco.get(q).getDuracion(), listaDisco.get(q).getPrecio(), "DISCO",-1));
                            List<Cancion> listaCancion = serviceCancion.getListaCancion();
                            for(int w=0;w<listaCancion.size();w++){
                                if(listaCancion.get(w).getIdDisco()==listaDisco.get(q).getId()){
                                    listaCompra.add(new BusquedaCompra(listaCancion.get(w).getId(), listaUsuario.get(i).getNombreArtistico(), listaDisco.get(q).getNombreDisco(), listaCancion.get(w).getNombreCancion(), listaCancion.get(w).getGenero(), listaCancion.get(w).getDuracionCancion(), listaCancion.get(w).getPrecion(), "CANCIÓN",listaDisco.get(i).getId()));
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (tipo.equals("2")) {
                System.out.println("ENTRO AL TIPO 2");
                List<Disco> listaDisco = serviceDisco.getListaDiscos();
                for (int i = 0; i < listaDisco.size(); i++) {
                    System.out.println("PRIMER FOR");
                    if (listaDisco.get(i).getNombreDisco().equals(nombre)) {
                        System.out.println("PRIMER IF");
                        List<Artista> listaUsuario = serviceArtista.getListaArtista();
                        for (int q = 0; q < listaUsuario.size(); q++) {
                            System.out.println("SEGUNDO FOR");
                            if (listaUsuario.get(q).getId() == listaDisco.get(i).getIdArtista()) {
                                System.out.println("SEGUNDO IF");
                                listaCompra.add(new BusquedaCompra(listaDisco.get(i).getId(), listaUsuario.get(q).getNombreArtistico(), listaDisco.get(i).getNombreDisco(), "no aplica", listaDisco.get(i).getGenero(), listaDisco.get(i).getDuracion(), listaDisco.get(i).getPrecio(), "DISCO", -1));
                            }
                        }
                    }
                }
            } else {
                if (tipo.equals("3")) {
                    System.out.println("ENTRO AL TIPO 3");
                    List<Cancion> listaCancion = serviceCancion.getListaCancion();
                    for (int w = 0; w < listaCancion.size(); w++) {
                        if (listaCancion.get(w).getNombreCancion().equals(nombre)) {
                            List<Disco> listaDisco = serviceDisco.getListaDiscos();
                            for (int i = 0; i < listaDisco.size(); i++) {
                                if (listaDisco.get(i).getId() == listaCancion.get(w).getIdDisco()) {
                                    List<Artista> listaUsuario = serviceArtista.getListaArtista();
                                    for (int q = 0; q < listaUsuario.size(); q++) {
                                        if (listaUsuario.get(q).getId() == listaDisco.get(i).getIdArtista()) {
                                            listaCompra.add(new BusquedaCompra(listaDisco.get(i).getId(), listaUsuario.get(q).getNombreArtistico(), listaDisco.get(i).getNombreDisco(), listaCancion.get(w).getNombreCancion(), listaCancion.get(w).getGenero(), listaCancion.get(w).getDuracionCancion(), listaCancion.get(w).getPrecion(), "CANCIÓN", listaDisco.get(i).getId()));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return listaCompra;
    }

    public List<BusquedaCompra> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<BusquedaCompra> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
