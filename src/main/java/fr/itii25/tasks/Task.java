package fr.itii25.tasks;

import fr.itii25.models.dao.DAO;

import java.util.HashMap;
import java.util.Map;

public abstract class Task extends Thread {

    private Map<Class<?>, DAO<?>> daos = new HashMap<>();
    protected boolean running = false;

    public final DAO<?> getDao(Class<?> persistentClass) {  //TODO: Mettre ça a la place de la création manuel dans le thread emetteur
        return daos.computeIfAbsent(persistentClass,  _ -> DAO.of(persistentClass, "output_postgres"));
    }

    public final void requestStop() {
        this.running = false;
    }

}
