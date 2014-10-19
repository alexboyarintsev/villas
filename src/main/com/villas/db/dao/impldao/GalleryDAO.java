package main.com.villas.db.dao.impldao;

import main.com.villas.db.dao.AbstractHibernateDao;
import main.com.villas.db.dao.idao.IGalleryDao;
import main.com.villas.db.domain.Gallery;
import org.springframework.stereotype.Repository;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
@Repository
public class GalleryDAO extends AbstractHibernateDao<Gallery> implements IGalleryDao {

        public GalleryDAO() {
            super();
            setClazz(Gallery.class);
        }
}
