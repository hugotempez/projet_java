package fr.itii25.models.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

public class DAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;
    private final String persistenceUnitName;
    private final SessionFactory sessionFactory;

    private final Class<T> persistentClass;

    public static <T> DAO<T> of(Class<T> persistentClass, String persistenceUnitName) {
        return new DAO<>(persistentClass, persistenceUnitName);
    }

    private DAO(Class<T> persistentClass, String persistenceUnitName) {
        this.persistentClass = persistentClass;
        this.persistenceUnitName = persistenceUnitName;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = emf.createEntityManager();
        Configuration config = new Configuration();
        config.addClass(persistentClass);
        sessionFactory = config.buildSessionFactory();
    }

    public T find(int id) throws SQLException {
        return entityManager.find(persistentClass, id);
    }

    public List<T> findAll() throws SQLException {
        return entityManager.createQuery("from " + persistentClass.getSimpleName()).getResultList();
    }

    public boolean create(T object) throws SQLException {
        //entityManager.merge(object);
//        entityManager.getTransaction().begin();
//
//        try {
//            entityManager.persist(object);
//            entityManager.getTransaction().commit();
//            System.out.println("Created: " + object);
//            return true;
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            e.printStackTrace();
//            return false;
//        }
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(object);
            session.flush();
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        //sessionFactory.close();
}

}
