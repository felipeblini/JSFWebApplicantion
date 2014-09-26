/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowdmobile.dao.imp;

import com.crowdmobile.dao.IGenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDAO<T> extends HibernateDaoSupport implements IGenericDAO<T> {

    public GenericDAO() {
        this.persistentClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private Class<T> persistentClass;

    public Class<T> getPersistentClass() throws Exception {
        return this.persistentClass;
    }

    @Override
    public void exclui(T entity) throws Exception{
        getHibernateTemplate().delete(entity);
        getHibernateTemplate().flush();
    }

    @Override
    public T buscaPeloID(int id) throws Exception{
        return (T) getHibernateTemplate().get(getPersistentClass(), id);
    }

    @Override
    public List<T> buscaTodos() throws Exception{
        return getHibernateTemplate().loadAll(persistentClass);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public T salva(T entity) throws Exception{
        getHibernateTemplate().save(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public T merge(T entity) throws Exception{
        getHibernateTemplate().merge(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    @Override
    public T salvarOuAtualizar(T entity)throws Exception{
        getHibernateTemplate().saveOrUpdate(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    @Override
    public T atualiza(T entity) throws Exception{
        getHibernateTemplate().update(entity);
        getHibernateTemplate().flush();
        return entity;
    }

    @Override
    public List<T> buscaListaPeloCriterio(Criterion... criterion) throws Exception{
        Session session = getSession();
        Criteria crit = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    @Override
    public List<T> buscaListaPeloCriterio(Order order, Criterion... criterion) throws Exception{
        Session session = getSession();
        Criteria crit = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        crit.addOrder(order);
        return crit.list();
    }

    @Override
    public T buscaUmPeloCriterio(Criterion... criterion) throws Exception{
        Session session = getSession();
        Criteria crit = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return (T) crit.uniqueResult();
    }
}