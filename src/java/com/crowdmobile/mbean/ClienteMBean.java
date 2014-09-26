/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.mbean;

import com.crowdmobile.domain.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author blini
 */
@ManagedBean
@SessionScoped
public class ClienteMBean implements Serializable {
    private Cliente cliente;
    private List<Cliente> lista;

    public ClienteMBean() {
        cliente = new Cliente();
        lista = new ArrayList<Cliente>();
    }
    
    public void salvar(){

        if(!lista.contains(cliente)){
            lista.add(cliente);
        }

        cliente = new Cliente();
    }
    
    public void remover(){
        lista.remove(cliente);
        cliente = new Cliente();
    }
    
    //getters and setter
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

}
