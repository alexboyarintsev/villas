package main.com.villas.service.implservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.dao.idao.IGalleryDao;
import main.com.villas.db.domain.Gallery;
import main.com.villas.service.AbstractService;
import main.com.villas.service.iservice.IGalleryService;
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

    @Autowired
    private IGalleryDao galleryDao;

    public GalleryService() {
        super();
    }

    public void saveImage(long villaId, MultipartFile image, String extention) {
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
        gallery.setImageName(image.getName());

        galleryDao.create(gallery);
    }

    @Override
    public byte[] readImage(String imageName) {
        return galleryDao.findByName(imageName).getImage();
    }

    @Override
    public List<String> getImageNamesByVillaId(long villaId) {
        return null;
    }

    @Override
    protected IOperations<Gallery> getDao() {
            return galleryDao;
        }

}
