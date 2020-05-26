/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.logic.ServiceCancion;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "login")
@SessionScoped 
public class Login implements Serializable{
    
    @Inject
    private ServiceArtista serviceArtista;
    @Inject
    private ServiceDisco serviceDisco;
    @Inject
    private ServiceCancion serviceCancion;
    
    public void crearArchivos(){
        System.out.println("entro al metodo crearARCHIVOS -------- login");
        serviceArtista.crearArtista();
        System.out.println("entro al metodo crearARCHIVOS -------- login2");
        serviceDisco.crearArchicoDisco();
        System.out.println("entro al metodo crearARCHIVOS -------- login3");
        serviceCancion.crearArchicoCancion();
    }
    
}
