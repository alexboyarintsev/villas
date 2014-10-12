package main.com.villas.service.implservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.dao.idao.IReservationDao;
import main.com.villas.db.domain.Customer;
import main.com.villas.db.domain.Reservation;
import main.com.villas.db.domain.Villa;
import main.com.villas.service.AbstractService;
import main.com.villas.service.iservice.IReservationService;
import main.com.villas.service.iservice.IVillaService;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
@Service
public class ReservationService extends AbstractService<Reservation> implements IReservationService {

    public final static DateTimeFormatter timeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    @Autowired
    private IReservationDao reservationDao;

    @Autowired
    private IVillaService villaService;

    public ReservationService() {
        super();
    }

    @Override
    protected IOperations<Reservation> getDao() {
        return reservationDao;
    }

    public void createWithPreProcessing(Customer customer, long villaId, DateTime dateStart, DateTime dateFinish) {
        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        Villa villa = villaService.findOne(villaId);
        reservation.setVilla(villa);
        reservation.setDatePlaced(new Date());
        reservation.setDateStart(dateStart.toDate());
        reservation.setDateFinish(dateFinish.toDate());
        int totalDays = getTotalDays(dateStart, dateFinish);
        reservation.setTotalDays(totalDays);
        BigDecimal relevantPrice = getRelevantPrice(villa.getPrice());
        reservation.setPrice(relevantPrice);
        reservation.setTotalPrice(calculateTotalPrice(relevantPrice, totalDays));
        reservation.setStatus((byte)0);
        create(reservation);
    }

    public List<Date> getBookedDates(long villaId) {
        List<Reservation> reservations = reservationDao.findByVillaId(villaId);
        List<Date> days = new ArrayList<>();
        for (Reservation reservation : reservations) {
            DateTime start = new DateTime(reservation.getDateStart());
            DateTime stop = new DateTime(reservation.getDateFinish());
            DateTime inter = start;
            while (inter.compareTo(stop) <= 0) {
                days.add(inter.toDate());
                inter = inter.plusDays(1);
            }
        }
        return days;
    }

    @Override
    public List<Reservation> findWaiting() {
        return reservationDao.findWaiting();
    }

    @Override
    public List<Reservation> findApproved() {
        return reservationDao.findApproved();
    }

    @Override
    public List<Reservation> findRejected() {
        return reservationDao.findRejected();
    }

    @Override
    public void markWaiting(long reservationId) {
        Reservation r = reservationDao.findOne(reservationId);
        r.setStatus((byte)0);
    }

    @Override
    public void markApproved(long reservationId) {
        Reservation r = reservationDao.findOne(reservationId);
        r.setStatus((byte)1);
    }

    @Override
    public void markRejected(long reservationId) {
        Reservation r = reservationDao.findOne(reservationId);
        r.setStatus((byte)-1);
    }

    private int getTotalDays(DateTime dateStart, DateTime dateFinish) {
        return Days.daysBetween(dateStart, dateFinish).getDays();
    }

    private BigDecimal getRelevantPrice(BigDecimal price) {
        //TODO here calculate price according to season
        return price;
    }

    private BigDecimal calculateTotalPrice(BigDecimal price, int totalDays) {
        return price.multiply(new BigDecimal(totalDays));
    }
}
