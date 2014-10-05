package main.com.villas.web.controller;

import com.google.gson.Gson;
import main.com.villas.db.domain.Villa;
import main.com.villas.service.implservice.TestDataService;
import main.com.villas.service.implservice.VillaService;
import main.com.villas.service.iservice.IVillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Controller
public class ApiController {

    @Autowired
    private IVillaService villaService;

    @Autowired
    private TestDataService testDataService;

    private final Gson gson = new Gson();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    String hello() {
        return "Hello!";
    }

    @RequestMapping(value = "api/villas", method = RequestMethod.GET)
    public @ResponseBody
    String getVillas() {
        List<Villa> villas = new ArrayList<>();
        try {
            villas = villaService.findAll();
        } catch (Exception e) {
            // TODO handle it
        }
        return gson.toJson(villas);
    }

    @RequestMapping(value = "api/generate", method = RequestMethod.GET)
    void generate() throws Exception {
        testDataService.generate();
    }

}
