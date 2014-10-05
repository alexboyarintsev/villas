package main.com.villas.db.dao;

/**
 * Created by aboyarintsev on 05.10.2014.
 */
import java.io.Serializable;
import java.util.List;

public interface IOperations<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);

}
