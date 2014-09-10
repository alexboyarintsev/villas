package main.com.villas.db.dao;

import main.com.villas.db.domain.Villa;
import org.springframework.stereotype.Repository;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Repository
public class VillaDAO extends DAO<Villa> {

    public VillaDAO() {
        super(Villa.class);
    }

}
