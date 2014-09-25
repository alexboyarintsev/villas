package main.com.villas.db.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
public abstract class DAO<E> extends HibernateDaoSupport {

    private final Class<E> entityClass;

    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    protected DAO(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public E findById(final Long id) {
        return getHibernateTemplate().execute(new HibernateCallback<E>() {
            @Override
            public E doInHibernate(Session session) throws HibernateException {
                Criteria cr = session.createCriteria(entityClass);
                cr.add(Restrictions.eq("id", id));
                return (E)cr.uniqueResult();
            }
        });
    }

    public E findByName(final String name) {
        return getHibernateTemplate().execute(new HibernateCallback<E>() {
            @Override
            public E doInHibernate(Session session) throws HibernateException {
                Criteria cr = session.createCriteria(entityClass);
                cr.add(Restrictions.eq("name", name));
                return (E)cr.uniqueResult();
            }
        });
    }

    public List<E> findByCriteria(final Set<Criterion> criterions, final Order order) {
        return getHibernateTemplate().execute(new HibernateCallback<List<E>>() {
            @Override
            public List<E> doInHibernate(Session session) throws HibernateException {
                Criteria cr = session.createCriteria(entityClass);
                for (Criterion criterion : criterions) cr.add(criterion);
                if(order != null) cr.addOrder(order);

                return cr.list();
            }
        });
    }

    public List<E> findByCriteria(final Criterion criterion, final Order order) {
        return getHibernateTemplate().execute(new HibernateCallback<List<E>>() {
            @Override
            public List<E> doInHibernate(Session session) throws HibernateException {
                Criteria cr = session.createCriteria(entityClass);
                cr.add(criterion);
                if(order != null) cr.addOrder(order);

                return cr.list();
            }
        });
    }

    // TODO move to service layer - just testing
    @Transactional
    public E create(E e) throws Exception {
        getHibernateTemplate().saveOrUpdate(e);
        return e;
    }

    // TODO move to service layer - just testing
    @Transactional
    public void delete(E e) throws Exception {
        getHibernateTemplate().delete(e);
    }

    // TODO move to service layer - just testing
    @Transactional
    public E update(E e) throws Exception {
        getHibernateTemplate().update(e);
        return e;
    }

    public List<E> findAll() throws Exception {
        return getHibernateTemplate().loadAll(entityClass);
    }

}