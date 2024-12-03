package fr.itii25.models.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

public class DAO<T> {

    @PersistenceContext
    static protected EntityManager entityManager;
    private final String persistenceUnitName;

    private final Class<T> persistentClass;

    public static <T> DAO<T> of(Class<T> persistentClass, String persistenceUnitName) {
        return new DAO<>(persistentClass, persistenceUnitName);
    }

    private DAO(Class<T> persistentClass, String persistenceUnitName) {
        this.persistentClass = persistentClass;
        this.persistenceUnitName = persistenceUnitName;
        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = emf.createEntityManager();
        }
    }

    public T find(int id) throws SQLException {
        return entityManager.find(persistentClass, id);
    }

    public List<T> findAll() throws SQLException {
        return entityManager.createQuery("from " + persistentClass.getSimpleName()).getResultList();
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
