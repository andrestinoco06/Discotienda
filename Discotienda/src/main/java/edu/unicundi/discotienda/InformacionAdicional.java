/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceDisco;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "administrador")
@ViewScoped 
public class InformacionAdicional {
    
    @PostConstruct
    public void init() {
        cargarInformacion();
    }
    
    @Inject
    private ServiceArtista serviceArtista;
    
    @Inject
    private ServiceDisco serviceDisco;
    
    private void cargarInformacion(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map params = externalContext.getRequestParameterMap();
        int informacion = new Integer((String) params.get("informacion"));
        int tipo = new Integer((String) params.get("tipo"));
        if(tipo==1){
            
        }
        
    }
    
}
