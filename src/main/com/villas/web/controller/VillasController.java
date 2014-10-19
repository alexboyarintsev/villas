package main.com.villas.web.controller;

import main.com.villas.db.domain.Gallery;
import main.com.villas.db.domain.Villa;
import main.com.villas.service.iservice.IVillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
@Controller
@RequestMapping(value = "admin/villas")
class VillasController {

    @Autowired
    private IVillaService villaService;

    @RequestMapping(method = RequestMethod.GET, params = "new")
    String newVilla() {
        return "villas/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestParam String name, @RequestParam String description,
                @RequestParam String price, @RequestParam MultipartFile file) {

        Villa v = new Villa();
        v.setName(name);
        v.setDescription(description);
        v.setPrice(new BigDecimal(price));
        Gallery g = new Gallery();
        g.setPictureName("picture_here");
        v.setGallery(g);
        villaService.create(v);

        System.out.println(v);
    }
}
