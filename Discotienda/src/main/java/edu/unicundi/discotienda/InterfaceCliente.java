package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceUsuario;
import edu.unicundi.model.UsuarioModel;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean para procesar las acciones que se esten realizando en su correspondiente vista.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 * @version 1.0.0
 */
@Named(value = "interfaceCliente")
@ViewScoped
public class InterfaceCliente implements Serializable {

    /**
     * Variable de tipo String para almacenar el nombre del cliente.
     */
    private String nombre;

    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceUsuario.
     */
    @Inject
    private ServiceUsuario serviceUsuario;

    /**
     * PostConstructor para obtener el usuario que se esta logueando.
     */
    @PostConstruct
    public void init() {
        if (serviceUsuario.validacionCliente()) {
            int id = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionCliente");
            List<UsuarioModel> lista = serviceUsuario.getListaUsuario();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    nombre = lista.get(i).getNombre() + " " + lista.get(i).getApellido();
                }
            }
        }
    }

    /**
     * Método que direcciona a la vista bienvenidaCliente.
     */
    public void inicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("bienvenidaCliente.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que direcciona a la vista compra.
     */
    public void comprar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("compra.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que direcciona a la vista carrito.
     */
    public void carrito() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("carrito.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para cerrar la sesión del usuario que se logueo en el navegador.
     */
    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionCliente", false);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSessionCliente", null);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para acceder al historial de compras del usuario.
     */
    public void historialDeCompras() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("historialCompraUsuario.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
