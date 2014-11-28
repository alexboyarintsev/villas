package main.com.villas.web.controller;

import main.com.villas.db.domain.Customer;
import main.com.villas.db.domain.Reservation;
import main.com.villas.db.dto.ReservationDto;
import main.com.villas.service.iservice.IPdfService;
import main.com.villas.service.iservice.IReservationService;
import main.com.villas.service.iservice.IVillaService;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aboyarintsev on 11/15/2014.
 */
@Controller
class ReservationController {

    private static final Logger LOG = LoggerFactory.getLogger(ReservationController.class);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    IReservationService reservationService;

    @Autowired
    IPdfService pdfService;

    @RequestMapping(value = "reservations", method = RequestMethod.GET, params = "new")
    String newVilla() {
        return "reservations/new";
    }

//    @RequestMapping(value = "reservations", method = RequestMethod.POST, produces = "application/pdf")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    byte[] createReservation(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String passportNo,
//                             @RequestParam String phone, @RequestParam String email, @RequestParam String dateStart,
//                             @RequestParam String dateFinish, @RequestParam long villaId) throws IOException, COSVisitorException {
//        Customer customer = new Customer();
//        customer.setFirstName(firstname);
//        customer.setLastName(lastname);
//        customer.setPassportNo(passportNo);
//        customer.setPhone(phone);
//        customer.setEmail(email);
//
//        reservationService.createWithPreProcessing(customer, villaId, dateStart, dateFinish);
//
//        return pdfService.drawInvoice();
//    }

    @RequestMapping(value = "reservations", method = RequestMethod.POST, produces = "application/pdf")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    byte[] createReservation(@RequestParam("reservation") ReservationDto reservationDto) throws IOException, COSVisitorException {
        reservationService.createWithPreProcessing(reservationDto);
        return pdfService.drawInvoice();
    }

}
