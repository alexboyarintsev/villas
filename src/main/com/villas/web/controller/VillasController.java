package main.com.villas.web.controller;

import com.google.gson.Gson;
import main.com.villas.db.domain.Villa;
import main.com.villas.service.iservice.IGalleryService;
import main.com.villas.service.iservice.IVillaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
@Controller
@RequestMapping(value = "admin")
class VillasController {

    private static final Logger LOG = LoggerFactory.getLogger(VillasController.class);
    private final Gson gson = new Gson();

    @Autowired
    private IVillaService villaService;

    @Autowired
    private IGalleryService galleryService;

    @RequestMapping(value = "villas", method = RequestMethod.GET, params = "new")
    String newVilla() {
        return "villas/new";
    }

    @RequestMapping(value = "villas", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    String createVilla(@RequestParam String name, @RequestParam String fileName, @RequestParam String description,
                @RequestParam String price, @RequestParam MultipartFile file) {

        Villa v = new Villa();
        v.setName(name);
        v.setDescription(description);
        v.setPrice(new BigDecimal(price));
        villaService.create(v);

        if(!file.isEmpty()) {
            galleryService.saveImage(v.getId(), file, fileName);
        } else {
            //set default image
        }
        return "villas/index";
    }

    @RequestMapping(value = "villas", method = RequestMethod.GET)
    public String getVillas() throws IOException {
        return "villas/index";
    }

    @RequestMapping(value = "villas/{id}/galleries", method = RequestMethod.GET)
    @ResponseBody
    public String getImage(@PathVariable long id) throws IOException {
        return gson.toJson(galleryService.findImageNamesByVillaId(id));
    }

    @RequestMapping(value = "api/villas", method = RequestMethod.GET)
    @ResponseBody
    public String getVillasJson() throws IOException {
        return gson.toJson(villaService.findVillas());
    }

}
