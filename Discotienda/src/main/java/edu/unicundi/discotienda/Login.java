package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceBusquedaCompra;
import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.logic.ServiceCancion;
import edu.unicundi.logic.ServiceUsuario;
import edu.unicundi.model.UsuarioModel;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean para procesar las acciones que se esten realizando en su correspondiente vista.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 * @version 1.0.0
 */
@Named(value = "login")
@RequestScoped 
public class Login implements Serializable{
    
    /**
     * Variables de tipo String  que almacenan los datos usuario, clave, titulo de la vista Login.
     */
    private String usuario, clave, titulo;
    
    /**
     * PostConstructor para dar valor a la variable titulo.
     */
    @PostConstruct
    public void init() {
        System.out.println("entro al post del login");
        this.titulo = "Iniciar Sesión";
    }
    
    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de ServiceArtista.
     */
    @Inject
    private ServiceArtista serviceArtista;
    
    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceDisco.
     */
    @Inject
    private ServiceDisco serviceDisco;
    
    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceCancion.
     */
    @Inject
    private ServiceCancion serviceCancion;
    
    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceUsuario.
     */
    @Inject
    private ServiceUsuario serviceUsuario;
    
    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceBusquedaCompra.
     */
    @Inject
    private ServiceBusquedaCompra serviceBusquedaCompra;
    
    
    /**
     * Método para validar si los datos del usuario que se loguea son correctos para posteriormente direccionar a la página de su respectivo rol.
     */
    public void iniciarSesion(){
        List<UsuarioModel> listaUsuario = serviceUsuario.getListaUsuario();
        for(int i=0;i<listaUsuario.size();i++){
            if(listaUsuario.get(i).getDocumento().equals(usuario)){
                if(listaUsuario.get(i).getContrasena().equals(clave)){
                    if(listaUsuario.get(i).getIdRol() == 1){
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionAdministrador", true);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSessionAdministrador", listaUsuario.get(i).getId());
                        try {
                            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/artistasAdministrador.xhtml");
                        } catch (IOException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionCliente", true);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idSessionCliente", listaUsuario.get(i).getId());
                        try {
                            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/bienvenidaCliente.xhtml");
                        } catch (IOException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Método para crear los archivos que se usarán como información para la ejecución del proyecto.
     */
    public void crearArchivos(){
        System.out.println("entro al metodo crearARCHIVOS -------- login");
        try {
            serviceArtista.crearArtista();
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("entro al metodo crearARCHIVOS -------- login2");
        try {
            serviceDisco.crearArchicoDisco();
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("entro al metodo crearARCHIVOS -------- login3");
        try {
            serviceCancion.crearArchicoCancion();
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("entro al metodo crearARCHIVOS -------- login4");
        serviceUsuario.crearUsuario();
        System.out.println("entro al metodo crearARCHIVOS -------- login5");
        serviceBusquedaCompra.crearArchivoCarro();
    }

    /**
     * Método que direcciona a la vista registrarUsuario.
     */
    public void registrar(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/registroUsuario.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
