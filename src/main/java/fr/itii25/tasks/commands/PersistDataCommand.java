package fr.itii25.tasks.commands;

import fr.itii25.models.dao.DAO;
import fr.itii25.models.dao.DB;
import fr.itii25.tasks.Task;

import java.sql.SQLException;

public class PersistDataCommand<T> implements Command {

    private final T data;

    public PersistDataCommand(T data) {
        this.data = data;
    }

    @Override
    public void execute(Task task) {
        try {
            DAO<T> dao = (DAO<T>) task.getDao(data.getClass(), DB.POSTGRES.getValue());
            dao.create(data);
        }
        catch (ClassCastException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Received command to persist " + data);
    }
}