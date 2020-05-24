/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.lecturaEscritura;

import edu.unicundi.discotienda.Administrador;
import edu.unicundi.model.Disco;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johan
 */
public class lecturaEscrituraDisco {
    
    public void crearArchivo() {
        List<Disco> lista = new ArrayList<>();
        lista.add(new Disco(1, 1, 240000, "10-08-1985", "POP-FUNK", 2010, "24K Magic"));
        lista.add(new Disco(2, 1, 270000, "06-12-2012", "POP-FUNK", 2091, "Unorthodox Jukebox"));
        lista.add(new Disco(3, 2, 365000, "26-05-2017", "POP LATINO-REGUETÓN-POP", 2637, "El dorado"));
        lista.add(new Disco(4, 3, 370000, "01-10-1960", "ROCK", 1595, "G.I. Blues"));
        System.out.println("ENTRO CREAR DISCO");
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ADisco.txt");            
            try {
                ObjectOutputStream oos = new ObjectOutputStream(fos);          
                oos.writeObject(lista);
                oos.flush();
                oos.close();
                System.out.println("CREO ARTISTA");
            } catch (IOException ex) {
                Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Disco> verDiscos(){
        List<Disco> listaL = null;
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ADisco.txt");
            ObjectInputStream listaDiscos = new ObjectInputStream(fis);
            listaL = (List<Disco>) listaDiscos.readObject();
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