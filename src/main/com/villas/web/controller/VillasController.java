package main.com.villas.web.controller;

import main.com.villas.db.domain.Gallery;
import main.com.villas.db.domain.Villa;
import main.com.villas.service.iservice.IGalleryService;
import main.com.villas.service.iservice.IVillaService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
@Controller
@RequestMapping(value = "admin/villas")
class VillasController {

    private static final Logger LOG = LoggerFactory.getLogger(VillasController.class);

    @Autowired
    private IVillaService villaService;

    @Autowired
    private IGalleryService galleryService;

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
        villaService.create(v);

        if(!file.isEmpty()) {
            String contentType = file.getContentType();
            switch(contentType) {
                case "application/pdf" : galleryService.saveImage(v.getId(), file, "pdf"); break;
                case "image/jpeg" : galleryService.saveImage(v.getId(), file, "jpeg"); break;
                default :
                    LOG.error("Error : unsupported media format");
                    // show some error or sth
            }
        } else {
            //set default image
        }
    }

    @RequestMapping(value = "image/{name}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] returnImage(@PathVariable String name) throws IOException {
        return galleryService.readImage(name);
    }
}
