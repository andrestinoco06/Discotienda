/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.lecturaEscritura;

import com.sun.corba.se.impl.io.IIOPOutputStream;
import edu.unicundi.discotienda.Administrador;
import edu.unicundi.model.Artista;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class lecturaEscrituraArtista {

    public void crearArchivo() {
        List<Artista> lista = new ArrayList<>();
        lista.add(new Artista(1, "Bruno Mars", "Peter Gene Hernandez", "POP-FUNK", "10-08-1985"));
        lista.add(new Artista(2, "Shakira", "Shakira Isabel Mebarak Ripoll", "POP-ROCK EN ESPAÑOL", "02-02-1977"));
        lista.add(new Artista(3, "Elvis Presley", "Elvis Aaron Presley", "POP-ROCK-COUNTRY", "08-01-1935"));
        lista.add(new Artista(4, "Redimi2", "Willy González Cruz", "HIP HOP CRISTIANO-RAP-TRAP", "03-06-1979"));
        System.out.println("ENTRO CREAR ARTISTA");
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\AArtista.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
            System.out.println("CREO ARTISTA");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Artista> verArtistas() {
        List<Artista> listaL = null;
        FileInputStream fis = null;
        System.out.println("Entro a ver al artista");
        try {
            fis = new FileInputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\AArtista.txt");
            ObjectInputStream listaEntrada = new ObjectInputStream(fis);
            listaL = (List<Artista>) listaEntrada.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaL;
    }
}