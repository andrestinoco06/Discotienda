/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Gambito
 */
@Named(value = "usuario")
@RequestScoped
public class Usuario {

    /**
     * Creates a new instance of Usuario
     */
    public Usuario() {
    }
    
}
