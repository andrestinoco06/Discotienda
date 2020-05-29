/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceBusquedaCompra;
import edu.unicundi.model.BusquedaCompra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "carritoUsuario")
@ViewScoped
public class Carrito implements Serializable{
    
    List<BusquedaCompra> listaCarrito;
    
    @Inject
    private Compra compra;
    
    @Inject
    private ServiceBusquedaCompra serviceCompra;

    @PostConstruct
    public void init() {
        listaCarrito = compra.getCarrito();
    }

    public void eliminarCarrito(BusquedaCompra eliminar){
        System.out.println("entro a eliminar");
        System.out.println(" --  "+eliminar.getNombreDisco()+" "+eliminar.getNombreArtista());
        compra.getCarrito().remove(eliminar);
    }
    
    public void confimarCompra(){
        serviceCompra.agregarCarrito(listaCarrito);
        listaCarrito.removeAll(listaCarrito);
        listaCarrito = new ArrayList<>();
        compra.setCarrito(listaCarrito);
    }
    
    public List<BusquedaCompra> getListaCarrito() {
        return listaCarrito;
    }

    public void setListaCarrito(List<BusquedaCompra> listaCarrito) {
        this.listaCarrito = listaCarrito;
    }
}