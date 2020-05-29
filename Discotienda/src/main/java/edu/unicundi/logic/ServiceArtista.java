package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraArtista;
import edu.unicundi.model.Artista;
import edu.unicundi.model.Cancion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * ServiceArtista para realizar la logica correspondiente al modelo Artista.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 */
@Named(value = "serviceArtista")
@RequestScoped
public class ServiceArtista {
    
    /**
     * List de tipo Artista para almacenar los artistas.
     */
    private List<Artista> listaArtista;
    
    /**
     * Constructor vacío
     */
    public ServiceArtista(){
        
    }
    
    /**
     * PostConstructor para ver los artistas que se encuentran almacenados
     */
    @PostConstruct
    public void init() {
        System.out.println(" entro al POSTconstructor SERVICE");
        listaArtista = new lecturaEscrituraArtista().verArtistas();
    }
    
    /**
     * Método para quemar Artistas en el archivo AArtistas.
     * @throws ParseException 
     */
    public void crearArtista() throws ParseException{
        System.out.println(" entro al METODO CREAR ARTISTA ");
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
        Date dt_1 = objSDF.parse("20-08-1981"); 
        Date dt_2 = objSDF.parse("12-10-2012"); 
        List<Artista> lista = new ArrayList<>();
        lista.add(new Artista(1, "Bruno Mars", "Peter Gene Hernandez", "POP-FUNK", dt_1));
        lista.add(new Artista(2, "Shakira", "Shakira Isabel Mebarak Ripoll", "POP-ROCK EN ESPAÑOL", dt_1));
        lista.add(new Artista(3, "Elvis Presley", "Elvis Aaron Presley", "POP-ROCK-COUNTRY", dt_1));
        lista.add(new Artista(4, "Redimi2", "Willy González Cruz", "HIP HOP CRISTIANO-RAP-TRAP", dt_2));
        new lecturaEscrituraArtista().crearArchivo(lista);
    }

    public List<Artista> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<Artista> listaArtista) {
        this.listaArtista = listaArtista;
    }
    
    
    
}
