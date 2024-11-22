package fr.itii25.dao;

import fr.itii25.db.DatabaseConnection;

import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {

    protected DatabaseConnection connection;

    /**
     * Permet de récupérer un objet via son ID
     * @param id ID de l'objet à chercher
     */
    public abstract T find(long id) throws SQLException;

    public abstract List<T> findAll();

    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    public abstract boolean create(T obj);

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     * @param obj
     */
    public abstract boolean update(T obj);

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    public abstract boolean delete(T obj);
}
