package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraDisco;
import edu.unicundi.model.Disco;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * ServiceDisco para realizar la logica correspondiente al modelo Disco.
 * @author Camilo Tinoco
 * @author Johan Zambrano
 */
@Named(value = "serviceDisco")
@RequestScoped
public class ServiceDisco {
    
    /**
     * List de tipo Disco para almacenar los discos.
     */
    List<Disco> listaDisco;
    
    /**
     * Constructor vacío
     */
    public ServiceDisco(){
        
    }
    
    /**
     * PostConstructor para ver los discos que se encuentran almacenados
     */
    @PostConstruct
    public void init() {
        listaDisco = new lecturaEscrituraDisco().verDiscos();
    }
    
    /**
     * Método para quemar Disco en el archivo ADiscos.
     * @throws ParseException 
     */
    public void crearArchicoDisco() throws ParseException{
        List<Disco> lista = new ArrayList<>();
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
        Date dt_1 = objSDF.parse("20-08-2012"); 
        Date dt_2 = objSDF.parse("12-10-2019");
        lista.add(new Disco(1, 1, 240000, dt_1, "POP-FUNK", 2010, "24K Magic"));
        lista.add(new Disco(2, 1, 270000, dt_1, "POP-FUNK", 2091, "Unorthodox Jukebox"));
        lista.add(new Disco(3, 2, 365000, dt_2, "POP LATINO-REGUETÓN-POP", 2637, "El dorado"));
        lista.add(new Disco(4, 3, 370000, dt_2, "ROCK", 1595, "G.I. Blues"));
        new lecturaEscrituraDisco().crearArchivo(lista);
    }
    
    public List<Disco> getListaDiscos() {
        return listaDisco;
    }

    public void setListaDiscos(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }
}
