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
@Named(value = "interfaceAdmin")
@ViewScoped
public class InterfaceAdmin implements Serializable {

    /**
     * Variable de tipo String para almacenar el nombre del administrador.
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
        if (serviceUsuario.validacionUsuario()) {
            int id = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionAdministrador");
            List<UsuarioModel> lista = serviceUsuario.getListaUsuario();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    nombre = lista.get(i).getNombre() + " " +lista.get(i).getApellido();
                }
            }
        }
    }

    /**
     * Método para cerrar la sesión del usuario que se logueo en el navegador.
     */
    public void cerrarSessionAdmin() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionAdministrador", false);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSessionAdministrador", null);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * Método que direcciona a la vista artistaAdministrador.
     */
    public void registrarArtistas() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("artistasAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * * Método que direcciona a la vista discosAdministrador.
     */
    public void verDiscos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("discosAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * Método que direcciona a la vista cancionesAdministrador.
     */
    public void verCanciones() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cancionesAdministrador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
