package main.com.villas.service.implservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.dao.idao.IGalleryDao;
import main.com.villas.db.domain.Gallery;
import main.com.villas.service.AbstractService;
import main.com.villas.service.iservice.IGalleryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
@Service
public class GalleryService extends AbstractService<Gallery> implements IGalleryService {

    private static final Logger LOG = LoggerFactory.getLogger(GalleryService.class);

    private final static String JPEG = "jpg";
    private final static String PDF = "pdf";

    @Autowired
    private IGalleryDao galleryDao;

    public GalleryService() {
        super();
    }

    public void saveImage(long villaId, MultipartFile image, String fileName) {
        String contentType = image.getContentType();
        String extension;
        switch(contentType) {
            case "application/pdf" : extension = JPEG; break;
            case "image/jpeg" : extension = PDF; break;
            default :
                LOG.error("Error : unsupported media format");
                return;
                // show some error or sth
        }
        byte[] bImage = new byte[(int) image.getSize()];

        try (InputStream inputStream = image.getInputStream()) {
            inputStream.read(bImage);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gallery gallery = new Gallery();
        gallery.setVillaId(villaId);
        gallery.setImage(bImage);
        String imageName = fileName != null ? fileName : image.getOriginalFilename();
        gallery.setImageName(imageName);
        gallery.setExtension(extension);

        galleryDao.create(gallery);
    }

    @Override
    public byte[] readImage(String imageName) {
        return galleryDao.findByName(imageName).getImage();
    }

    @Override
    public List<String> findImageNamesByVillaId(long villaId) {
        return galleryDao.findImageNamesByVillaId(villaId);
    };

    @Override
    protected IOperations<Gallery> getDao() {
            return galleryDao;
        }

}
