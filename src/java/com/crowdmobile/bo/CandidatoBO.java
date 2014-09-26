/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.bo;

import com.crowdmobile.config.BeanFactory;
import com.crowdmobile.dao.imp.CandidatoDAO;
import com.crowdmobile.domain.Candidato;
import java.util.List;

/**
 *
 * @author blini
 */
public class CandidatoBO {
    private CandidatoDAO usudao = (CandidatoDAO)BeanFactory.getBean("candidatoDAO", CandidatoDAO.class);
    
    public List<Candidato> buscaTodos()throws Exception{
        return usudao.buscaTodos();
    }
    
    public Candidato salva(Candidato candidato) throws Exception {
        return usudao.salva(candidato);
    }
    
    public Candidato atualiza(Candidato candidato) throws Exception {
        return usudao.atualiza(candidato);
    }
 
    public Candidato merge(Candidato candidato) throws Exception {
        return usudao.merge(candidato);
    }
    
    public void excluir(Candidato candidsto) throws Exception {
        usudao.exclui(candidsto);
    }
}
