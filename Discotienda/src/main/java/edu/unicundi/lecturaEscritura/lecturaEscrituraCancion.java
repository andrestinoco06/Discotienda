/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.lecturaEscritura;

import edu.unicundi.discotienda.Administrador;
import edu.unicundi.model.Cancion;
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
public class lecturaEscrituraCancion {
    public void crearArchivo() {
        List<Cancion> lista = new ArrayList<>();
        lista.add(new Cancion(1, 3, "Chantaje", 195, "28-10-2016" , "POP LATINO-REGUETON", 35000));
        lista.add(new Cancion(2, 3, "La bicicleta", 228, "27-05-2016" , "POP LATINO-REGUETON", 40000));
        lista.add(new Cancion(3, 2, "Locked Out of Heaven", 233, "01-10-2012" , "ROCK", 33000));
        
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ACancion.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Cancion> verCancion() {
        List<Cancion> listaL = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ACancion.txt");
            ObjectInputStream listaEntrada = new ObjectInputStream(fis);
            listaL = (List<Cancion>) listaEntrada.readObject();
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