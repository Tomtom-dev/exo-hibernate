package org.formhib.repositories;

import org.formhib.utils.SessionHibernate;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class MysqlRepository<T> {


    /**
     * Permet de récuperer un records
     * @param id
     * @return
     */
    public T get(int id, Class<T> type){
        Session session = SessionHibernate.currentSession();
        return session.get(type,id);
    }

    /**
     * Permet de persister un records
     * @param {T} object
     */

    public void save(T object){
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }

    /**
     * Permet de récuperer une liste de records
     * @return
     */

    public List<T> getAll(Class<T> type){
        Session session = SessionHibernate.currentSession();

        CriteriaBuilder criteriaBuilder= session.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(type);
        Root<T> root = query.from(type);
        CriteriaQuery<T> all = query.select(root);
        TypedQuery<T> allQuery = session.createQuery(all);

        return allQuery.getResultList();
    }

    /**
     * Permet de supprimer un records
     * @param object
     */
    public void delete(T object){
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }

    /**
     * Permet de mettre à jour un object
     * @param object
     */
    public void update(T object) {
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }
}
