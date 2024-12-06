package fr.itii25.tasks.commands;

import fr.itii25.models.dao.DAO;
import fr.itii25.models.dao.DB;
import fr.itii25.tasks.Task;

import java.sql.SQLException;

/**
 * Implémentation du design pattern Command pour l'échange de données
 * @param <T>
 */
public class PersistDataCommand<T> implements Command {

    private final T data;   //La donnée à échanger

    public PersistDataCommand(T data) {
        this.data = data;
    }

    /**
     * Persiste la data dans la table qui correspond a son type
     * @param task
     */
    @Override
    public void execute(Task task) {
        if (task == null) {
            System.out.println("Task is null");
            return;
        }
        try {
            //Récupération du DAO associé au type de la donnée
            DAO<T> dao = (DAO<T>) task.getDao(data.getClass(), DB.POSTGRES.getValue());
            //Pérsistance de la donnée
            dao.create(data);
        }
        catch (ClassCastException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Received command to persist " + data);
    }
}