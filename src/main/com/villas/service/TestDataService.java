package main.com.villas.service;

import main.com.villas.db.domain.Villa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Service
public class TestDataService {

    private static final int VILLAS_COUNT = 100;
    private static final int PRICE_RANGE = 500;

    private final Random random = new Random();

    @Autowired
    private VillaService villaService;

    public void generate() throws Exception {
        generateVillas();
    }

    public void generateVillas() throws Exception {
        for (int i = 0; i < VILLAS_COUNT; i++) {
            Villa villa = new Villa();
            villa.setName("Villa" + i + 1);
            villa.setCover("picture_path");
            villa.setDescription("desc");
            villa.setPrice(new BigDecimal(random.nextInt(PRICE_RANGE) + 10));
            villaService.create(villa);
        }
    }
}
