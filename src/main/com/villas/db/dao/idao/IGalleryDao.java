package main.com.villas.db.dao.idao;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.domain.Gallery;
import main.com.villas.db.domain.Reservation;

import java.util.List;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
public interface IGalleryDao extends IOperations<Gallery> {

    Gallery findByName(String name);

    List<String> findImageNamesByVillaId(long villaId);
}
