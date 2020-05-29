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
 * Bean para procesar las acciones que se esten realizando en la vista Carrito del usuario
 * @author Johan Zambrano
 * @author Camilo Tinoco
 */
@Named(value = "carritoUsuario")
@ViewScoped
public class Carrito implements Serializable{
    
    /**
     * Variable de tipo List que almacena todos los productos que se han seleccionado 
     */
    List<BusquedaCompra> listaCarrito;
    
    /**
     * Variable de tipo Inject, realiza la injeccion a Compra
     */
    @Inject
    private Compra compra;
    
    /**
     * Variable de tipo Inject, realiza la injeccion a ServiceBusquedacOMPRA
     */
    @Inject
    private ServiceBusquedaCompra serviceCompra;
    
    /**
     * PostConstruct, trae toda la información del carrito y la carga en la List
     */
    @PostConstruct
    public void init() {
        listaCarrito = compra.getCarrito();
    }
    
    /**
     * Elimina un dato del carrito
     * @param eliminar Almacena el dato a eliminar
     */
    public void eliminarCarrito(BusquedaCompra eliminar){
        System.out.println("entro a eliminar");
        System.out.println(" --  "+eliminar.getNombreDisco()+" "+eliminar.getNombreArtista());
        compra.getCarrito().remove(eliminar);
    }
    
    /**
     * Función que confirma la compra del usuario
     */
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