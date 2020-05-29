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
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "historialCompra")
@RequestScoped
public class HistorialCompraUsuario implements Serializable {

    List<BusquedaCompra> listaCarrito;

    @Inject
    private ServiceBusquedaCompra serviceCompra;

    @PostConstruct
    public void init() {
        listaCarrito = new ArrayList<>();
        List<BusquedaCompra> lista = serviceCompra.historialUsuario();
        System.out.println(" entro ");
        int id = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionCliente");
        System.out.println(" id " + id);
        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(" entro for");
                if (lista.get(i).getIdUsuario() == id) {
                    System.out.println(" entro if");
                    listaCarrito.add(lista.get(i));
                }
            }
        }
    }

    public List<BusquedaCompra> getListaCarrito() {
        return listaCarrito;
    }

    public void setListaCarrito(List<BusquedaCompra> listaCarrito) {
        this.listaCarrito = listaCarrito;
    }

}
