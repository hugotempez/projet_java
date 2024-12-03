package fr.itii25.tasks;

import fr.itii25.models.dao.DAO;

import java.util.HashMap;
import java.util.Map;

public abstract class Task extends Thread {

    private final Map<Class<?>, DAO<?>> daos = new HashMap<>();
    protected boolean running = false;

    public final DAO<?> getDao(Class<?> persistentClass, String persistenceUnitName) {
        return daos.computeIfAbsent(persistentClass,  _ -> DAO.of(persistentClass, persistenceUnitName));
    }

    public final void requestStop() {
        this.running = false;
    }

}
