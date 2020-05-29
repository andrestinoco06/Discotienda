package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceUsuario;
import edu.unicundi.model.UsuarioModel;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean para procesar las acciones que se esten realizando en su correspondiente vista.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 * @version 1.0.0
 */
@Named(value = "registroUsuario")
@ViewScoped 
public class RegistroUser implements Serializable{
    
    /**
     * Variables de tipo String nombre, apellido, correo, direccion, documento, clave, telefono y titulo para almacenar los atributos de Usuario.
     */
    private String nombre, apellido, correo, direccion, documento, clave, telefono, titulo;
    
    /**
     * Variables de tipo int para almacernar la edad del Usuario
     */
    private int edad;
    
    /**
     * Constructor vacío.
     */
    public RegistroUser(){
        
    }
    
    /**
     * Postconstructor para darle valor a la variable titulo.
     */
    @PostConstruct
    public void init() {
        this.titulo = "Registro";
    }
    
    /**
     * Inyeccion de dependencias para acceder a los atributos y métodos de serviceUsuario.
     */
    @Inject
    private ServiceUsuario serviceUsuario;
    
    /**
     * Método para registrar un usuario.
     */
    public void registro(){
        List<UsuarioModel> listaUsuarios = serviceUsuario.getListaUsuario();
        listaUsuarios.add(new UsuarioModel(listaUsuarios.size()+1, nombre, apellido, correo, direccion, documento, clave, edad, 2, telefono));
        serviceUsuario.agregarUsuario(listaUsuarios);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
