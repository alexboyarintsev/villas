package main.com.villas.service.implservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.dao.idao.IGalleryDao;
import main.com.villas.db.domain.Gallery;
import main.com.villas.service.AbstractService;
import main.com.villas.service.iservice.IGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        @Override
        protected IOperations<Gallery> getDao() {
            return galleryDao;
        }

}
