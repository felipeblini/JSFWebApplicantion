/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author blini
 */
@Entity
@Table(name = "candidato")
public class Candidato {
    
    @Id
    private int codigo;

    private String nome;

    private String foto;
    
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "candidato")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Voto> listaVotos;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Voto> getListaVotos() {
        return listaVotos;
    }

    public void setListaVotos(List<Voto> listaVotos) {
        this.listaVotos = listaVotos;
    }
}
