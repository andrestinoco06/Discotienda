/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.lecturaEscritura;

import edu.unicundi.discotienda.ArtistasAdministrador;
import edu.unicundi.model.Cancion;
import java.io.File;
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
 * Funcion que realiza la lectura, escritura de Archivos por parte de las
 * Canciones
 *
 * @author Johan Zambrano
 * @author Camilo Tinoco
 */
public class lecturaEscrituraCancion {

    /**
     * Funcion que crea el archivo de las canciones
     *
     * @param lista recibe la lista de tipo Artista con los datos a guardar
     */
    public void crearArchivo(List<Cancion> lista) {
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

    /**
     * Funcion que retorna una lista con los datos que estaban en el archivo
     *
     * @return lista de cancion
     */
    public List<Cancion> verCancion() {
        List<Cancion> listaL = null;
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ACancion.txt");
            if (fis != null) {
                ObjectInputStream listaEntrada = new ObjectInputStream(fis);
                listaL = (List<Cancion>) listaEntrada.readObject();
            } else {
                System.out.println("NO ENCONTRO ARTISTA, NO EXISTE EL ARCHIVO");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaL;
    }

    /**
     * Funcion que agrega una canción nueva
     *
     * @param lista trae todos los datos a agregar
     */
    public void agregarCancion(List<Cancion> lista) {

        //Borra el fichero
        try {
            File Ffichero = new File("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ACancion.txt");
            if (Ffichero.exists()) {
                Ffichero.delete();
                System.out.println("BORRO");
            }
            System.out.println("lista ESCRITURA " + lista.size());
            //crea un nuevo fichero con la información 
            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ACancion.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
            System.out.println("CREO Cancion NUEVO");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
