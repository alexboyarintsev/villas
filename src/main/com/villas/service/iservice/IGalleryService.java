package main.com.villas.service.iservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.domain.Gallery;
import main.com.villas.db.dto.VillaDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
public interface IGalleryService extends IOperations<Gallery> {

    void saveImage(long villaId, MultipartFile image, String fileName);

    byte[] readImage(String imageName);

    List<String> findImageNamesByVillaId(long villaId);

}
