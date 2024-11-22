package fr.itii25.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DAO<T> {

    protected Connection connection;

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> persistentClass;

    public static <T> DAO<T> of(Class<T> persistentClass) {
        return new DAO<T>(persistentClass);
    }

    private DAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public T find(long id) throws SQLException {
        return entityManager.find(persistentClass, id);
    }

    public boolean create(T object) throws SQLException {
        try {
            entityManager.persist(object);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
