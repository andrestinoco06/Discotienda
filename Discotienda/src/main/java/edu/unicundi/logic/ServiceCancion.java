/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.logic;

import edu.unicundi.model.Cancion;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "serviceCancion")
@RequestScoped
public class ServiceCancion {
    
    List<Cancion> listaCancion;
    
    
}
