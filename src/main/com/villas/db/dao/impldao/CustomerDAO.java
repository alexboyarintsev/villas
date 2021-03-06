package main.com.villas.db.dao.impldao;

import main.com.villas.db.dao.AbstractHibernateDao;
import main.com.villas.db.dao.idao.ICustomerDao;
import main.com.villas.db.domain.Customer;
import org.springframework.stereotype.Repository;

/**
 * Created by aboyarintsev on 10.09.2014.
 */
@Repository
public class CustomerDAO extends AbstractHibernateDao<Customer> implements ICustomerDao {

    public CustomerDAO() {
        super();
        setClazz(Customer.class);
    }

}
