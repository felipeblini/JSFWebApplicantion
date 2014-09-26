/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.mbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author blini
 */
@ManagedBean
@RequestScoped
public class CalculadoraMBean implements Serializable {

    /**
     * Creates a new instance of CalculadoraMBean
     */
    
    private int campo1;
    private int campo2;
    private int soma;
    
    public CalculadoraMBean() {
    }
    
    public void somar(){
        soma = campo1+campo2;
    }

    public int getCampo1() {
        return campo1;
    }

    public void setCampo1(int campo1) {
        this.campo1 = campo1;
    }

    public int getCampo2() {
        return campo2;
    }

    public void setCampo2(int campo2) {
        this.campo2 = campo2;
    }

    public int getSoma() {
        return soma;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }
}
