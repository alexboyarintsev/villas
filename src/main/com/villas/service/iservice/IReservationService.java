package main.com.villas.service.iservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.domain.Customer;
import main.com.villas.db.domain.Reservation;
import org.joda.time.DateTime;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
public interface IReservationService extends IOperations<Reservation> {

    void createWithPreProcessing(Customer customer, long villaId, DateTime dateStart, DateTime dateFinish);
}
