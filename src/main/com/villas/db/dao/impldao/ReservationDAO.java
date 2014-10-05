package main.com.villas.db.dao.impldao;

import main.com.villas.db.dao.AbstractHibernateDao;
import main.com.villas.db.dao.idao.IReservationDao;
import main.com.villas.db.domain.Reservation;
import org.springframework.stereotype.Repository;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Repository
public class ReservationDao extends AbstractHibernateDao<Reservation> implements IReservationDao{

    public ReservationDao() {
        super();
        setClazz(Reservation.class);
    }

}
