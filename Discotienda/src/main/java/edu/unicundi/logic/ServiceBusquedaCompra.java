package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraCarrito;
import edu.unicundi.model.Artista;
import edu.unicundi.model.BusquedaCompra;
import edu.unicundi.model.Cancion;
import edu.unicundi.model.Disco;
import edu.unicundi.model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ServiceCancion para realizar la logica correspondiente al modelo Cancion.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 */
@Named(value = "serviceBusquedaCompra")
@RequestScoped
public class ServiceBusquedaCompra {
    
    /**
     * List de tipo BusquedaCompra para almacenar los las compras que se hayan realizado.
     */
    private List<BusquedaCompra> listaCompra;
    
    /**
     * List de tipo BusquedaCompra para almacenar los las compras que se hayan realizado.
     */
    private List<BusquedaCompra> listaHistoria;
    
    /**
     * Variables de tipo String para almacenar los datos nombre y tipo de la BusquedaCompra.
     */
    private String nombre, tipo;
    
    /**
     * Constructo vacío
     */
    public ServiceBusquedaCompra(){
        
    }
    
    /**
     * PostConstructor vacío
     */
    @PostConstruct
    public void init() {
        //listaCompra = new lecturaEscrituraCarrito().verCarro();
    }
    
    /**
     * Inyeccion de dependencias del serviceArtista para acceder a sus atributos y métodos
     */
    @Inject
    private ServiceArtista serviceArtista;

    /**
     * Inyeccion de dependencias del serviceCancion para acceder a sus atributos y métodos
     */
    @Inject
    private ServiceCancion serviceCancion;

    /**
     * Inyeccion de dependencias del serviceUsuario para acceder a sus atributos y métodos
     */
    @Inject
    private ServiceUsuario serviceUsuario;

    /**
     * Inyeccion de dependencias del serviceDisco para acceder a sus atributos y métodos
     */
    @Inject
    private ServiceDisco serviceDisco;
    
    /**
     * Método para cargar la lista de la compras que ha realizado el cliente.
     * @return listaCompra
     */
    public List<BusquedaCompra> cargarLista(){
        listaCompra = new ArrayList<>();
        listaCompra.add(new BusquedaCompra(-1, "vacio", "vacio", "vacio", "vacio", 0, 0, "vacio", -1, 0,0));
        return listaCompra;
    }
    
    /**
     * Método para crear el archivo del carrito de compras.
     */
    public void crearArchivoCarro(){
        List<BusquedaCompra> lista = new ArrayList<>();
        new lecturaEscrituraCarrito().agregarCarro(lista);
    }
    
    /**
     * Método para almacenar canciones al carrito de compras.
     * @param agregarCarrito 
     */
    public void agregarCarrito(List<BusquedaCompra> agregarCarrito){
        new lecturaEscrituraCarrito().agregarCarro(agregarCarrito);
    }
    
    /**
     * Método para ver el historial de compras que ha realizado el cliente.
     * @return 
     */
    public List<BusquedaCompra> historialUsuario(){
        return new lecturaEscrituraCarrito().verCarro();
    }
    
    /**
     * Método para realizar el filtro por artista, disco o canciones que se encuentren registradas, posteriormente
     * carga en una lista los resultados obtenidos.
     * @param nombre
     * @param tipo
     * @return 
     */
    public List<BusquedaCompra> realizarBusqueda(String nombre, String tipo){
        listaCompra = new ArrayList<>();
        int cont=1;
        if (tipo.equals("1")) {
            List<Artista> listaUsuario = serviceArtista.getListaArtista();
            for (int i = 0; i < listaUsuario.size(); i++) {
                if(listaUsuario.get(i).getNombreArtistico().contains(nombre)){
                    List<Disco> listaDisco = serviceDisco.getListaDiscos();
                    for(int q=0;q<listaDisco.size();q++){
                        if(listaDisco.get(q).getIdArtista()==listaUsuario.get(i).getId()){
                            listaCompra.add(new BusquedaCompra(cont, listaUsuario.get(i).getNombreArtistico(), listaDisco.get(q).getNombreDisco(), "no aplica", listaDisco.get(q).getGenero(), listaDisco.get(q).getDuracion(), listaDisco.get(q).getPrecio(), "DISCO", listaDisco.get(i).getId(), 0, (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionCliente")));
                            cont++;
                            List<Cancion> listaCancion = serviceCancion.getListaCancion();
                            for(int w=0;w<listaCancion.size();w++){
                                if(listaCancion.get(w).getIdDisco()==listaDisco.get(q).getId()){
                                    listaCompra.add(new BusquedaCompra(cont, listaUsuario.get(i).getNombreArtistico(), listaDisco.get(q).getNombreDisco(), listaCancion.get(w).getNombreCancion(), listaCancion.get(w).getGenero(), listaCancion.get(w).getDuracionCancion(), listaCancion.get(w).getPrecion(), "CANCIÓN",listaDisco.get(i).getId(), listaCancion.get(w).getId(), (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionCliente")));
                                    cont++;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (tipo.equals("2")) {
                System.out.println("ENTRO AL TIPO 2");
                List<Disco> listaDisco = serviceDisco.getListaDiscos();
                for (int i = 0; i < listaDisco.size(); i++) {
                    System.out.println("PRIMER FOR");
                    if (listaDisco.get(i).getNombreDisco().equals(nombre)) {
                        System.out.println("PRIMER IF");
                        List<Artista> listaUsuario = serviceArtista.getListaArtista();
                        for (int q = 0; q < listaUsuario.size(); q++) {
                            System.out.println("SEGUNDO FOR");
                            if (listaUsuario.get(q).getId() == listaDisco.get(i).getIdArtista()) {
                                System.out.println("SEGUNDO IF");
                                listaCompra.add(new BusquedaCompra(cont, listaUsuario.get(q).getNombreArtistico(), listaDisco.get(i).getNombreDisco(), "no aplica", listaDisco.get(i).getGenero(), listaDisco.get(i).getDuracion(), listaDisco.get(i).getPrecio(), "DISCO",listaDisco.get(i).getId(), 0, (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionCliente")));
                                cont++;
                            }
                        }
                    }
                }
            } else {
                if (tipo.equals("3")) {
                    System.out.println("ENTRO AL TIPO 3");
                    List<Cancion> listaCancion = serviceCancion.getListaCancion();
                    for (int w = 0; w < listaCancion.size(); w++) {
                        if (listaCancion.get(w).getNombreCancion().equals(nombre)) {
                            List<Disco> listaDisco = serviceDisco.getListaDiscos();
                            for (int i = 0; i < listaDisco.size(); i++) {
                                if (listaDisco.get(i).getId() == listaCancion.get(w).getIdDisco()) {
                                    List<Artista> listaUsuario = serviceArtista.getListaArtista();
                                    for (int q = 0; q < listaUsuario.size(); q++) {
                                        if (listaUsuario.get(q).getId() == listaDisco.get(i).getIdArtista()) {
                                            listaCompra.add(new BusquedaCompra(cont, listaUsuario.get(q).getNombreArtistico(), listaDisco.get(i).getNombreDisco(), listaCancion.get(w).getNombreCancion(), listaCancion.get(w).getGenero(), listaCancion.get(w).getDuracionCancion(), listaCancion.get(w).getPrecion(), "CANCIÓN", listaDisco.get(i).getId(), listaCancion.get(w).getId(), (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idSessionCliente")));
                                            cont++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return listaCompra;
    }

    public List<BusquedaCompra> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<BusquedaCompra> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<BusquedaCompra> getListaHistoria() {
        return listaHistoria;
    }

    public void setListaHistoria(List<BusquedaCompra> listaHistoria) {
        this.listaHistoria = listaHistoria;
    }
    
    
    
}
