/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.bo;

import com.crowdmobile.config.BeanFactory;
import com.crowdmobile.dao.imp.VotoDAO;
import com.crowdmobile.domain.Voto;
import java.util.List;

/**
 *
 * @author blini
 */
public class VotoBO {
    private VotoDAO votodao = (VotoDAO)BeanFactory.getBean("votoDao", VotoDAO.class);
    
    public List<Voto> buscarTodos() throws Exception {
        return votodao.buscaTodos();
    }
    
    public Voto salva(Voto voto)throws Exception{
        return votodao.salva(voto);
    }
 
    public Voto atualiza(Voto voto)throws Exception{
        return votodao.atualiza(voto);
    }
 
    public Voto merge(Voto voto)throws Exception{
        return votodao.merge(voto);
    }
 
    public void exclui(Voto voto)throws Exception{
        votodao.exclui(voto);
    }
}
