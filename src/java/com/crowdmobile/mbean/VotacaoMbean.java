/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.mbean;

import com.crowdmobile.bo.CandidatoBO;
import com.crowdmobile.bo.VotoBO;
import com.crowdmobile.domain.Candidato;
import com.crowdmobile.domain.Voto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author blini
 */
@ManagedBean
@ViewScoped
public class VotacaoMbean implements Serializable {
 
    private Candidato candidato;
    private List<Candidato> listaCandidato;
    private CandidatoBO candidatobo;
    private VotoBO votobo;

    public VotacaoMbean() {
        candidatobo = new CandidatoBO();
        votobo = new VotoBO();
        listarCandidato();
    }
    
    public void listarCandidato() {
        try {
            //recupera todos os candidatos do banco
            listaCandidato = candidatobo.buscaTodos();
        } catch(Exception x){
            x.printStackTrace();
        }
    }
    
    public String votar() {
        //Verificamos se a lista de votos do candidato esta nula
        if(candidato.getListaVotos() == null){
            //se estiver, criamos uma nova lista
            candidato.setListaVotos(new ArrayList<Voto>());
        }
 
        //agora vamos criar os votos
        Voto voto = new Voto();
        voto.setData(new Date());
        //adicionamos o candidato
        voto.setCandidato(candidato);
 
        try {
            //e salvamos o voto
            votobo.salva(voto);
        } catch(Exception x){
            x.printStackTrace();
        }
 
        return "index.xhtml";
    }
    
    //getters and setters
    public List<Candidato> getListaCandidato() {
        return listaCandidato;
    }
 
    public void setListaCandidato(List<Candidato> listaCandidato) {
        this.listaCandidato = listaCandidato;
    }
 
    public Candidato getCandidato() {
        return candidato;
    }
 
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }   
}