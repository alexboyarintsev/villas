package main.com.villas.service.implservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.dao.idao.IVillaDao;
import main.com.villas.db.domain.Villa;
import main.com.villas.service.AbstractService;
import main.com.villas.service.iservice.IVillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Service
public class VillaService extends AbstractService<Villa> implements IVillaService {

    @Autowired
    private IVillaDao villaDAO;

    public VillaService() {
        super();
    }

    @Override
    protected IOperations<Villa> getDao() {
        return villaDAO;
    }

}
