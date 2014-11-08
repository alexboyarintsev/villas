package main.com.villas.service.implservice;

import main.com.villas.db.domain.Customer;
import main.com.villas.db.domain.Villa;
import main.com.villas.service.iservice.IReservationService;
import main.com.villas.service.iservice.IVillaService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Service
@Transactional
public class TestDataService {

    private static final int VILLAS_COUNT = 10;
    private static final int RESERVATIONS_COUNT = 10;
    private static final int PRICE_RANGE = 500;

    private final Random random = new Random();

    @Autowired
    private IVillaService villaService;

    @Autowired
    private IReservationService reservationService;

    public void generate() throws Exception {
        generateVillas();
        generateReservations();
    }

    public void generateVillas() throws Exception {
        for (int i = 0; i < VILLAS_COUNT; i++) {
            Villa villa = new Villa();
            villa.setName("Villa" + i + 1);
            villa.setDescription("desc");
            villa.setPrice(new BigDecimal(random.nextInt(PRICE_RANGE) + 10));
            villaService.create(villa);
        }
    }

    public void generateReservations() throws Exception {
        for (int i = 0; i < RESERVATIONS_COUNT; i++) {
            Customer c = new Customer();
            c.setFirstName("User" + i + 1);
            c.setLastName("User" + i + 99);
            c.setPassportNo(Integer.toString(random.nextInt(320000)));
            c.setEmail(Integer.toString(random.nextInt(320000)) + "@gmail.com");
            c.setPhone("80" + Integer.toString(random.nextInt(320000)));
            long villaId = villaService.findAll().get(random.nextInt(9)).getId();
            int randomDay = random.nextInt(28) + 1;
            int randomMonth = random.nextInt(12) + 1;
            int totalDays = random.nextInt(11) + 1;
            DateTime start = new DateTime(DateTime.parse("2014-" + randomMonth + "-" + randomDay));
            reservationService.createWithPreProcessing(c, villaId, new DateTime(start), start.plusDays(totalDays));
        }

    }
}
