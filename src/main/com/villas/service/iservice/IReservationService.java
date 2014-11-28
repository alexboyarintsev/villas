package main.com.villas.service.iservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.domain.Customer;
import main.com.villas.db.domain.Reservation;
import main.com.villas.db.dto.ReservationDto;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
public interface IReservationService extends IOperations<Reservation> {

    void createWithPreProcessing(Customer customer, long villaId, String dateStart, String dateFinish);

    void createWithPreProcessing(ReservationDto reservationDto);

    List<Date> getBookedDates(long villaId);

    List<Reservation> findWaiting();

    List<Reservation> findApproved();

    List<Reservation> findRejected();

    void markWaiting(long reservationId);

    void markApproved(long reservationId);

    void markRejected(long reservationId);
}
