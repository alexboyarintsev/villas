package main.com.villas.service.iservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.domain.Villa;
import main.com.villas.db.dto.VillaDto;

import java.util.List;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
public interface IVillaService extends IOperations<Villa> {

    List<VillaDto> findVillas();
}
