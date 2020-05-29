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
 * Bean para procesar las acciones que se esten realizando en su correspondiente vista.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 * @version 1.0.0
 */
@Named(value = "compraUsuario")
@SessionScoped
public class Compra implements Serializable {

    /**
     * Variables de tipo String para almacenar los datos tipo y nombre de la compra.
     */
    private String tipo, nombre;

    /**
     * List de tipo BusquedaCompra para almacenar la compra que se este realizando.
     */
    private List<BusquedaCompra> listaCompra;

    /**
     * * List de tipo BusquedaCompra para almacenar la compra que se este realizando.
     */
    private List<BusquedaCompra> carrito;

    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceBusquedaCompra.
     */
    @Inject
    private ServiceBusquedaCompra serviceBusquedaCompra;

    /**
     * PostConstructor vacío
     */
    @PostConstruct
    public void init() {
    }

    /**
     * Método que busca la BusquedaCompra según el nombre y tipo del usuario.
     */
    public void buscar() {
        listaCompra = new ArrayList<>();
        listaCompra = serviceBusquedaCompra.realizarBusqueda(nombre, tipo);
    }

    /**
     * Método para agregar canciones al carrito de compras.
     * @param busqueda 
     */
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
                    if (carrito.get(i).getIdDisco()== busqueda.getIdDisco() && carrito.get(i).getTipo().equals("DISCO")) {
                        System.out.println("encontro el mismo disco registrado");
                        validacion = 2;
                    }
                }
                List<BusquedaCompra> listaProvisional = new ArrayList<>();
                for (int q = 0; q < carrito.size(); q++) {
                    System.out.println(" carrito "+ carrito.size());
                    System.out.println("  " + carrito.get(q).getIdDisco() + " = " + busqueda.getIdDisco() + "  -  " +carrito.get(q).getTipo());
                    if (carrito.get(q).getIdDisco() == busqueda.getIdDisco() && carrito.get(q).getTipo().equals("CANCIÓN")) {
                        System.out.println("Entro a borrar las canciones que ya estan registradas");
                        System.out.println("  " + carrito.get(q).getIdDisco() + " - " + busqueda.getIdDisco() + "  -  " +carrito.get(q).getTipo());
                        System.out.println(" - disco: "+ carrito.get(q).getNombreDisco() + "  - cancion: "+ carrito.get(q).getNombreCancion());
                    }else{
                        listaProvisional.add(carrito.get(q));
                    }
                }
                carrito = listaProvisional;
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
            System.out.println(" validacion "+ validacion);
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
