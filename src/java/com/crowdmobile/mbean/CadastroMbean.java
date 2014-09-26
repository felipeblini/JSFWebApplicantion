/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.mbean;

import com.crowdmobile.bo.CandidatoBO;
import com.crowdmobile.domain.Candidato;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author blini
 */
@ManagedBean
@SessionScoped
public class CadastroMbean implements Serializable{
    private CandidatoBO candidatobo;
    private Candidato candidato;

    public CadastroMbean() {
        candidatobo = new CandidatoBO();
        candidato = new Candidato();
    }
    
    public String salvar () {
        try {
            candidatobo.merge(candidato);
            candidato = new Candidato();
        } catch(Exception x){
            x.printStackTrace();
        }
 
        return "Home.xhtml";
    }
    
    //getters and settesr

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
}
