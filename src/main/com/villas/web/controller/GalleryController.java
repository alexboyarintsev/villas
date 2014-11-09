package main.com.villas.web.controller;

import main.com.villas.service.iservice.IGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by aboyarintsev on 09.11.2014.
 */
@Controller
@RequestMapping(value = "admin/galleries")
class GalleryController {

    @Autowired
    private IGalleryService galleryService;

    @RequestMapping(method = RequestMethod.GET, params = "new")
    String newVilla() {
        return "galleries/new";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] returnImage(@PathVariable String name) throws IOException {
        return galleryService.readImage(name);
    }

}
