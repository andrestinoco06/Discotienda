/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.lecturaEscritura;

import edu.unicundi.discotienda.ArtistasAdministrador;
import edu.unicundi.model.Disco;
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
 * Funcion que realiza la lectura, escritura de Archivos por parte del Disco
 * @author Johan Zambrano
 * @author Camilo Tinoco
 */
public class lecturaEscrituraDisco {

    /**
     * Funcion que crea el archivo del Disco
     *
     * @param lista recibe la lista de tipo Disco con los datos a guardar
     */
    public void crearArchivo(List<Disco> lista) {
        System.out.println("ENTRO CREAR DISCO");
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ADisco.txt");
            try {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(lista);
                oos.flush();
                oos.close();
                System.out.println("CREO DISCO");
            } catch (IOException ex) {
                Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funcion que retorna una lista con los datos que estaban en el archivo
     *
     * @return lista de Disco
     */
    public List<Disco> verDiscos() {
        List<Disco> listaL = null;
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ADisco.txt");
            ObjectInputStream listaDiscos = new ObjectInputStream(fis);
            listaL = (List<Disco>) listaDiscos.readObject();
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
     * Funcion que agrega un disco nuevo
     *
     * @param lista trae todos los datos a agregar
     */
    public void agregarDisco(List<Disco> lista) {

        //Borra el fichero
        try {
            File Ffichero = new File("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ADisco.txt");
            if (Ffichero.exists()) {
                Ffichero.delete();
                System.out.println("BORRO");
            }
            System.out.println("lista ESCRITURA " + lista.size());
            //crea un nuevo fichero con la información 
            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\ADisco.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
            System.out.println("CREO DISCO NUEVO");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
