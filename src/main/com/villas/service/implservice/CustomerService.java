package main.com.villas.service.implservice;

import main.com.villas.db.dao.IOperations;
import main.com.villas.db.dao.idao.ICustomerDao;
import main.com.villas.db.domain.Customer;
import main.com.villas.service.AbstractService;
import main.com.villas.service.iservice.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
@Service
public class CustomerService extends AbstractService<Customer> implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    public CustomerService() {
        super();
    }

    @Override
    protected IOperations<Customer> getDao() {
        return customerDao;
    }
}
