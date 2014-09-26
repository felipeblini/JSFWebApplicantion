/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author blini
 */
@Entity
@Table(name = "voto")
public class Voto implements Serializable{
    
    @SequenceGenerator(sequenceName = "public.seq_voto", name = "seq_voto")
    @Id @GeneratedValue(generator = "seq_voto")
    private int codigo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "id_cadidato")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Candidato candidato;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voto other = (Voto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codigo;
        return hash;
    }
}
