/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.discotienda;

import edu.unicundi.logic.ServiceArtista;
import edu.unicundi.logic.ServiceDisco;
import edu.unicundi.model.Disco;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named(value = "discosArAd")
@ViewScoped
public class DiscosArtistasAdmin implements Serializable {

    private int idArtista;

    private List<Disco> listaDiscos;

    public DiscosArtistasAdmin() {
        System.out.println(" -  - -- - - entro al constructor DISCOS ");
    }

    @Inject
    private ServiceDisco serviceDisco;

    @PostConstruct
    public void init() {
        cargarDiscos();
    }

    public void cargarDiscos() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map params = externalContext.getRequestParameterMap();
        idArtista = new Integer((String) params.get("artista"));
        System.out.println(" -  - -- - - " + idArtista);
        this.listaDiscos = serviceDisco.getListaDiscos();
        List<Disco> listaBusqueda = new ArrayList<>();
        
        for (int i = 0; i < listaDiscos.size(); i++) {
            if (listaDiscos.get(i).getIdArtista() == idArtista) {
                listaBusqueda.add(listaDiscos.get(i));
            }
        }
        
        listaDiscos = listaBusqueda;
    }

    public List<Disco> getListaDiscos() {
        return listaDiscos;
    }

    public void setListaDiscos(List<Disco> listaDiscos) {
        this.listaDiscos = listaDiscos;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    
    
}
