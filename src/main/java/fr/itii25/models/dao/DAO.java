package fr.itii25.models.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

/**
 * Implémentation du design pattern DAO
 * @param <T> type d'objet manipulé
 */
public class DAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;
    private final Class<T> persistentClass; // Type d'objet manipulé

    /**
     * Simplification de l'appel au constructeur
     * @param persistentClass Type d'objet manipulé
     * @param persistenceUnitName SGBD cible
     * @return DAO
     * @param <T>
     */
    public static <T> DAO<T> of(Class<T> persistentClass, String persistenceUnitName) {
        return new DAO<>(persistentClass, persistenceUnitName);
    }

    /**
     * Constructeur
     * @param persistentClass Type d'objet manipulé
     * @param persistenceUnitName SGBD cible
     */
    private DAO(Class<T> persistentClass, String persistenceUnitName) {
        this.persistentClass = persistentClass;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = emf.createEntityManager();
    }

    /**
     * Récupération d'une entrée SQL pour un id passé en paramètre
     * @param id id de l'entrée à récupérer
     * @return Un objet qui représente l'entrée de base de donnée récupéré
     * @throws SQLException
     */
    public T find(int id) throws SQLException {
        return entityManager.find(persistentClass, id);
    }

    /**
     * Récupération d'une table SQL complète
     * @return Une List d'objet représentant les données recupéré
     * @throws SQLException
     */
    public List<T> findAll() throws SQLException {
        return entityManager.createQuery("from " + persistentClass.getSimpleName()).getResultList();
    }

    /**
     * Persist un objet dans une base de donnée
     * @param object L'objet à créer en base de donnée
     * @return booléen représentant la reussite ou non de la persistance
     * @throws SQLException
     */
    public boolean create(T object) throws SQLException {
        entityManager.getTransaction().begin();
        try {
            if (!entityManager.contains(object)) {
                entityManager.merge(object); // Réassocie l'entité détachée
            } else {
                entityManager.persist(object); // Persiste une nouvelle entité
            }
            entityManager.getTransaction().commit();    // Commit dans la table les changements
            System.out.println("Created: " + object);
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("Erreur lors de la pérsistance des données");
            return false;
        }
    }
}
