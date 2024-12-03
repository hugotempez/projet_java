package fr.itii25.tasks;

import fr.itii25.models.dao.DAO;

import java.util.HashMap;
import java.util.Map;

public abstract class Task extends Thread{

    private Map<Class<?>, DAO<?>> daos = new HashMap<>();
    protected boolean running = false;

    public final DAO<?> getDao(Class<?> persistentClass) {
        return daos.computeIfAbsent(persistentClass,  _ -> DAO.of(persistentClass));
    }

    public final void requestStop() {
        this.running = false;
    }

}
