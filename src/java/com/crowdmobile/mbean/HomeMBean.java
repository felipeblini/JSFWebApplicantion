/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.mbean;

import com.crowdmobile.bo.CandidatoBO;
import com.crowdmobile.domain.Candidato;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author blini
 */
@ManagedBean
@RequestScoped
public class HomeMBean {
    private CandidatoBO candidatobo;
    private List<Candidato> listaCandidato;
    private PieChartModel graficoPizza; 
    private CartesianChartModel graficoBarra;

    //construtor
    public HomeMBean() {
        candidatobo = new CandidatoBO();
        listar();
    }
    
    public void listar() {
        try {
            //recuperar todos os candidatos do banco
            listaCandidato = candidatobo.buscaTodos();
            
            gerarGraficoBarra();
            gerarGraficoPizza();
            
        } catch(Exception x){
            x.printStackTrace();
        }
    }

    //getters and setters
    public List<Candidato> getListaCandidato() {
        return listaCandidato;
    }

    public void setListaCandidato(List<Candidato> listaCandidato) {
        this.listaCandidato = listaCandidato;
    }
    
    private void gerarGraficoBarra(){
        graficoBarra = new CartesianChartModel();

        for(Candidato cand : listaCandidato){
            ChartSeries candidatos = new ChartSeries();  
            candidatos.setLabel(cand.getNome());
            candidatos.set("Candidatos", cand.getListaVotos().size());
            graficoBarra.addSeries(candidatos);
        }
    }

    private void gerarGraficoPizza(){
        graficoPizza = new PieChartModel();
        for(Candidato cand : listaCandidato){
            graficoPizza.set(cand.getNome(), cand.getListaVotos().size());
        }
    }
}
