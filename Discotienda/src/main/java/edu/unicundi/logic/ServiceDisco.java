/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.logic;

import edu.unicundi.lecturaEscritura.lecturaEscrituraDisco;
import edu.unicundi.model.Disco;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "serviceDisco")
@RequestScoped
public class ServiceDisco {
    List<Disco> listaDisco;
    
    public ServiceDisco(){
        
    }
    
    @PostConstruct
    public void init() {
        listaDisco = new lecturaEscrituraDisco().verDiscos();
    }

    public List<Disco> getListaDiscos() {
        return listaDisco;
    }

    public void setListaDiscos(List<Disco> listaDisco) {
        this.listaDisco = listaDisco;
    }
}
