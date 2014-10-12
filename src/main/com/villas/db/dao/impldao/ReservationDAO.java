package main.com.villas.db.dao.impldao;

import main.com.villas.db.dao.AbstractHibernateDao;
import main.com.villas.db.dao.idao.IReservationDao;
import main.com.villas.db.domain.Reservation;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Repository
public class ReservationDAO extends AbstractHibernateDao<Reservation> implements IReservationDao {

    public ReservationDAO() {
        super();
        setClazz(Reservation.class);
    }

    @Override
    public List<Reservation> findByVillaId(long villaId) {
//        query = session.createQuery("delete from Employee where id= :id");
//        query.setLong("id", 4);
//        result = query.executeUpdate();
//        System.out.println("Employee Delete Status="+result);
//        from Cat as cat where cat.mate.name like '%s%'
//        Query query = getCurrentSession().createQuery("from " + clazz.getName() + "as r where r.villa.id= :id" );
        Query query = getCurrentSession().createQuery("from " + clazz.getName() + " as r where r.villa.id= :id" );
        query.setLong("id", villaId);
        return query.list();
    }

    @Override
    public List<Reservation> findWaiting() {
        Query query = getCurrentSession().createQuery("from " + clazz.getName() + " as r where r.status = 0" );
        return query.list();
    }

    @Override
    public List<Reservation> findApproved() {
        Query query = getCurrentSession().createQuery("from " + clazz.getName() + " as r where r.status = 1" );
        return query.list();
    }

    @Override
    public List<Reservation> findRejected() {
        Query query = getCurrentSession().createQuery("from " + clazz.getName() + " as r where r.status = -1" );
        return query.list();
    }
}
