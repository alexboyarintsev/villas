package main.com.villas.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.com.villas.db.domain.Customer;
import main.com.villas.db.domain.Reservation;
import main.com.villas.service.iservice.ICustomerService;
import main.com.villas.service.iservice.IReservationService;
import main.com.villas.service.iservice.IVillaService;
import main.com.villas.util.ResponseStatus;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
@Controller
public class ReservationController {

    Gson gson = new GsonBuilder()
//            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .setDateFormat("yyyy-MM-dd")
            .create();

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IVillaService villaService;

//    @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate
    @RequestMapping(value = "reservations", method = RequestMethod.POST)
    public @ResponseBody
    String createReservation() {
        Customer c = new Customer();
        c.setFirstName("Leha");
        c.setLastName("Boy");
        c.setPassportNo("12341341");
        c.setEmail("4173537@gmail.com");
        c.setPhone("80634173537");
        long villaId = villaService.findAll().get(0).getId();
        reservationService.createWithPreProcessing(c, villaId, new DateTime(DateTime.parse("2014-10-16")), new DateTime(DateTime.parse("2014-10-26")));
        return gson.toJson("cool");
    }

    @RequestMapping(value = "reservations", method = RequestMethod.GET)
    public @ResponseBody
    String getReservations() {
        List<Reservation> res = reservationService.findAll();
        return gson.toJson(res);
    }

    @RequestMapping(value = "bookedDates", method = RequestMethod.GET)
    public @ResponseBody
    String getBookedDates() {
        List<Date> res = reservationService.getBookedDates(villaService.findAll().get(0).getId());
        return gson.toJson(res);
    }

    @RequestMapping(value = "customers", method = RequestMethod.POST)
    public @ResponseBody
    String createCustomers() {
        Customer c = new Customer();
        c.setFirstName("Leha");
        c.setLastName("Boy");
        c.setPassportNo("12341341");
        c.setEmail("4173537@gmail.com");
        c.setPhone("80634173537");
        customerService.create(c);
        return gson.toJson(c);
    }

    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public @ResponseBody
    String getCustomers() {
        return gson.toJson(customerService.findAll());
    }
}
