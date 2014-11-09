package main.com.villas.service.implservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.dao.idao.IVillaDao;
import main.com.villas.db.domain.Villa;
import main.com.villas.db.dto.VillaDto;
import main.com.villas.service.AbstractService;
import main.com.villas.service.iservice.IGalleryService;
import main.com.villas.service.iservice.IVillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Service
public class VillaService extends AbstractService<Villa> implements IVillaService {

    @Autowired
    private IVillaDao villaDAO;

    @Autowired
    private IGalleryService galleryService;

    public VillaService() {
        super();
    }

    @Override
    protected IOperations<Villa> getDao() {
        return villaDAO;
    }

    @Override
    public List<VillaDto> findVillas() {
        List<Villa> villas = findAll();
        List<VillaDto> villaDtos = new ArrayList<>();
        for (Villa v : villas) {
            List<String> images = galleryService.findImageNamesByVillaId(v.getId());
            VillaDto vd = new VillaDto(v, images);
            villaDtos.add(vd);
        }
        return villaDtos;
    }
}
