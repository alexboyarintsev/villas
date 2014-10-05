package main.com.villas.db.dao.impldao;

import main.com.villas.db.dao.AbstractHibernateDao;
import main.com.villas.db.dao.idao.IVillaDao;
import main.com.villas.db.domain.Villa;
import org.springframework.stereotype.Repository;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Repository
public class VillaDAO extends AbstractHibernateDao<Villa> implements IVillaDao {

    public VillaDAO() {
        super();
        setClazz(Villa.class);
    }

}
