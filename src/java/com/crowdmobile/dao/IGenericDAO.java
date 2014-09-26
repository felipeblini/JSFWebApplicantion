/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.dao;

import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 *
 * @author blini
 */
public interface IGenericDAO<T> {
    public T buscaPeloID(int id) throws Exception;

    public List<T> buscaTodos() throws Exception;

    public T salva(T entity) throws Exception;

    public T salvarOuAtualizar(T entity) throws Exception;

    public T atualiza(T entity) throws Exception;

    public void exclui(T entity) throws Exception;

    public List<T> buscaListaPeloCriterio(Criterion... criterion) throws Exception;

    public List<T> buscaListaPeloCriterio(Order order, Criterion... criterion) throws Exception;

    public T buscaUmPeloCriterio(Criterion... criterion) throws Exception;

    public T merge(T entity)throws Exception;
}
