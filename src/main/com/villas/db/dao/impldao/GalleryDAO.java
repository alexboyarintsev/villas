package main.com.villas.db.dao.impldao;

import main.com.villas.db.dao.AbstractHibernateDao;
import main.com.villas.db.dao.idao.IGalleryDao;
import main.com.villas.db.domain.Gallery;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aboyarintsev on 16.10.2014.
 */
@Repository
public class GalleryDAO extends AbstractHibernateDao<Gallery> implements IGalleryDao {

        public GalleryDAO() {
            super();
            setClazz(Gallery.class);
        }

    @Override
    public Gallery findByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(clazz.getName());
        return (Gallery) criteria.add(Restrictions.eq("imageName", name)).uniqueResult();
    }

    @Override
    public List<String> findImageNamesByVillaId(long villaId) {
//        String employeeName = session.createQuery("select empMaster.name from EmployeeMaster empMaster where empMaster.id = :id").setInteger("id",10).uniqueResult();

        Query query = getCurrentSession().createQuery("select gallery.imageName from " + clazz.getName() + " as gallery where gallery.villaId = " + villaId);
        return query.list();

    }
}
