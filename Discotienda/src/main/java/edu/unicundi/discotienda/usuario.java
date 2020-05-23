/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Gambito
 */
@Named(value = "usuario")
@SessionScoped
public class usuario implements Serializable {

    /**
     * Creates a new instance of usuario
     */
    public usuario() {
    }
    
}
