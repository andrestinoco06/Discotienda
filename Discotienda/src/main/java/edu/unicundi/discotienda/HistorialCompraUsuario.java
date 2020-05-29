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
 * Bean para procesar las acciones que se esten realizando en su correspondiente vista.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 * @version 1.0.0
 */
@Named(value = "historialCompra")
@RequestScoped
public class HistorialCompraUsuario implements Serializable {

    /**
     * Lista de tipo BusquedaCompra para almacenar las compras del usuario.
     */
    List<BusquedaCompra> listaCarrito;

    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceCompra.
     */
    @Inject
    private ServiceBusquedaCompra serviceCompra;

    /**
     * PostConstructor para cargar el dataTable, el cual recibe la listaCarrito.
     */
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
