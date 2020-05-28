/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceCancion;
import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceBusquedaCompra;
import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.logic.ServiceUsuario;
import edu.unicundi.model.Artista;
import edu.unicundi.model.BusquedaCompra;
import edu.unicundi.model.Cancion;
import edu.unicundi.model.Disco;
import edu.unicundi.model.UsuarioModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
@Named(value = "compraUsuario")
@SessionScoped
public class Compra implements Serializable {

    private String tipo, nombre;

    private List<BusquedaCompra> listaCompra;

    private List<BusquedaCompra> carrito;

    @Inject
    private ServiceBusquedaCompra serviceBusquedaCompra;

    @PostConstruct
    public void init() {
    }

    public void buscar() {
        listaCompra = new ArrayList<>();
        listaCompra = serviceBusquedaCompra.realizarBusqueda(nombre, tipo);
    }

    public void agregarCarrito(BusquedaCompra busqueda) {
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        if (!busqueda.equals(null)) {
            int validacion = 1;
            System.out.println("Entro carrito");
            if (busqueda.getTipo().equals("DISCO")) {
                System.out.println("Entro disco");
                for (int i = 0; i < carrito.size(); i++) {
                    if (carrito.get(i).getId() == busqueda.getId()) {
                        System.out.println("encontro el mismo disco registrado");
                        validacion = 2;
                    }
                }
                for (int q = 0; q < carrito.size(); q++) {
                    if (carrito.get(q).getIdDisco() == busqueda.getId()) {
                        System.out.println("Entro a borrar las canciones que ya estan registradas");
                        validacion = 3;
                        carrito.remove(q);
                    }
                }
            }
            if (busqueda.getTipo().equals("CANCIÓN")) {
                System.out.println("Entro cancion");
                for (int i = 0; i < carrito.size(); i++) {
                    if (carrito.get(i).getId() == busqueda.getId()) {
                        System.out.println("Encontro la misma cancion registrada");
                        validacion = 2;
                    }
                }
                for (int i = 0; i < carrito.size(); i++) {
                    if (carrito.get(i).getId() == busqueda.getIdDisco() && carrito.get(i).getTipo().equals("DISCO")) {
                        System.out.println("Encontro la cancion ingresada por un disco");
                        validacion = 4;
                    }
                }
            }
            if (validacion == 4) {
                FacesMessage msg = new FacesMessage("ERROR, LA CANCIÓN SELECCIONADA YA SE ENCUENTRA AGREGADA POR UN DISCO.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                if (validacion == 2) {
                    FacesMessage msg = new FacesMessage("ERROR,USTED YA AGREGO ESTE PRODUCTO AL CARRITO");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    if (validacion == 1) {
                        carrito.add(busqueda);
                        FacesMessage msg = new FacesMessage("Se agrego al carrito correctamente");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                }
            }
        }

        //serviceBusquedaCompra.agregarCarrito(listaCompra);
    }

    public List<BusquedaCompra> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<BusquedaCompra> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<BusquedaCompra> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<BusquedaCompra> carrito) {
        this.carrito = carrito;
    }

}
