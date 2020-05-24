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
    public void crearArchivo() throws ParseException{
        List<Artista> lista = new ArrayList<>();
        SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");
        lista.add(new Artista(1, "Bruno Mars", "Peter Gene Hernandez", "POP-FUNK", parseador.parse("10-08-1985")));
        lista.add(new Artista(2, "Shakira", "Shakira Isabel Mebarak Ripoll", "POP-ROCK EN ESPAÑOL", parseador.parse("02-02-1977")));
        lista.add(new Artista(3, "Elvis Presley", "Elvis Aaron Presley", "POP-ROCK-COUNTRY", parseador.parse("08-01-1935")));
        
        System.out.println("Entro al metodo");
        
        try {
            FileOutputStream fos = new FileOutputStream("AArtista.txt");
            try {
                
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                System.out.println("Creo");
                oos.writeObject(lista);
                oos.flush();
                oos.close();
                
                System.out.println("Cerro");
                
            } catch (IOException ex) {
                Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Artista> verArtistas(){
        FileInputStream fis;
        List<Artista> listaL = null;
        try {
            fis = new FileInputStream("AArtista.txt");
            ObjectInputStream ois;                
            ois = new ObjectInputStream(fis);
            listaL = (List<Artista>) ois.readObject();
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
