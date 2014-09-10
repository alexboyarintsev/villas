package main.com.villas.service;

import main.com.villas.db.dao.VillaDAO;
import main.com.villas.db.domain.Villa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Service
public class VillaService {

    @Autowired
    private VillaDAO villaDAO;

    public List<Villa> getVillas() throws Exception {
        return  villaDAO.findAll();
    }

    public void create(Villa villa) throws Exception {
        villaDAO.create(villa);
    }
}
