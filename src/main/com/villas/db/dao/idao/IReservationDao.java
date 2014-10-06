package main.com.villas.db.dao.idao;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.domain.Reservation;

import java.util.List;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
public interface IReservationDao extends IOperations<Reservation> {

    List<Reservation> findByVillaId(long villaId);
}
