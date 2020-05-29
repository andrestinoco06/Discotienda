/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.lecturaEscritura;

import com.sun.corba.se.impl.io.IIOPOutputStream;
import edu.unicundi.discotienda.ArtistasAdministrador;
import edu.unicundi.model.Artista;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Funcion que realiza la lectura, escritura de Archivos por parte del Artista
 * @author Johan Zambrano
 * @author Camilo Tinoco
 */
public class lecturaEscrituraArtista {
    /**
     * Funcion que crea el archivo del artista
     * @param lista recibe la lista de tipo Artista con los datos a guardar
     */
    public void crearArchivo(List<Artista> lista) {
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
    /**
     * Funcion que agrega un artista nuevo 
     * @param lista trae todos los datos a agregar
     */
    public void agregarArtista(List<Artista> lista) {

        //Borra el fichero
        try {
            File Ffichero = new File("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\AArtista.txt");
            if (Ffichero.exists()) {
                Ffichero.delete();
                System.out.println("BORRO");
            }
            System.out.println("lista ESCRITURA " + lista.size());
            //crea un nuevo fichero con la información 
            FileOutputStream fos = new FileOutputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\AArtista.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.flush();
            oos.close();
            System.out.println("CREO ARTISTA NUEVO");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Funcion que retorna una lista con los datos que estaban en el archivo
     * @return lista de artistas
     */
    public List<Artista> verArtistas() {
        List<Artista> listaL = null;
        FileInputStream fis = null;
        System.out.println("Entro a ver al artista");
        try {
            fis = new FileInputStream("C:\\Users\\johan\\Desktop\\Ingenieria de Sistemas\\Linea de profundizacion I\\RepositoriosCompartidos\\Discotienda\\AArtista.txt");
            if(fis != null){
                System.out.println("Entro a pesar de que no existe");
                ObjectInputStream listaEntrada = new ObjectInputStream(fis);
                listaL = (List<Artista>) listaEntrada.readObject();
            }else{
                System.out.println("NO ENCONTRO ARTISTA, NO EXISTE EL ARCHIVO");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArtistasAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(lecturaEscrituraArtista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("NO ENCONTRO ARTISTA, NO EXISTE EL ARCHIVO, EXCEPCIÓN");
        }
        return listaL;
    }
}
