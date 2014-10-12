package main.com.villas.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.com.villas.db.domain.Customer;
import main.com.villas.db.domain.Reservation;
import main.com.villas.service.iservice.ICustomerService;
import main.com.villas.service.iservice.IReservationService;
import main.com.villas.service.iservice.IVillaService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
@Controller
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

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

    @RequestMapping(value = "admin/reservations", method=RequestMethod.GET)
    String showReservations(HttpServletResponse response, Model model) {
        List<Reservation> reservationsWaiting = null;
        List<Reservation> reservationsApproved = null;
        List<Reservation> reservationsRejected = null;
        try {
            reservationsWaiting = reservationService.findWaiting();
            reservationsApproved = reservationService.findApproved();
            reservationsRejected = reservationService.findRejected();
        } catch (Exception e) {
            LOG.error("Error getting reservations : {}", e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        model.addAttribute("reservations_waiting", reservationsWaiting);
        model.addAttribute("reservations_approved", reservationsApproved);
        model.addAttribute("reservations_rejected", reservationsRejected);
        return "reservations/index";
    }

    @RequestMapping(value = "admin/reservations/{id}", method=RequestMethod.GET)
    String updateReservations(@PathVariable long id,
                            @RequestParam(value="status", required = false) Integer status ) {
        Reservation r = reservationService.findOne(id);
        if (status != null) { r.setStatus(status.byteValue()); }
        reservationService.update(r);
        return "redirect:/admin/reservations/";
    }

//    @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate
//    @RequestMapping(value = "reservations", method = RequestMethod.POST)
//    public @ResponseBody
//    String createReservation() {
//        Customer c = new Customer();
//        c.setFirstName("Leha");
//        c.setLastName("Boy");
//        c.setPassportNo("12341341");
//        c.setEmail("4173537@gmail.com");
//        c.setPhone("80634173537");
//        long villaId = villaService.findAll().get(0).getId();
//        reservationService.createWithPreProcessing(c, villaId, new DateTime(DateTime.parse("2014-10-16")), new DateTime(DateTime.parse("2014-10-26")));
//        return gson.toJson("cool");
//    }

//    @RequestMapping(value = "reservations", method = RequestMethod.GET)
//    public @ResponseBody
//    String getReservations() {
//        List<Reservation> res = reservationService.findAll();
//        return gson.toJson(res);
//    }

    @RequestMapping(value = "bookedDates", method = RequestMethod.GET)
    @ResponseBody
    String getBookedDates() {
        List<Date> res = reservationService.getBookedDates(villaService.findAll().get(0).getId());
        return gson.toJson(res);
    }

    @RequestMapping(value = "customers", method = RequestMethod.POST)
    @ResponseBody
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
    @ResponseBody
    String getCustomers() {
        return gson.toJson(customerService.findAll());
    }
}
