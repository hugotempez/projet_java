package fr.itii25.tasks;

import fr.itii25.models.dao.DAO;

import java.util.HashMap;
import java.util.Map;

/**
 * Interface commune aux threads émetteurs et récepteurs
 */
public abstract class Task extends Thread {

    private final Map<Class<?>, DAO<?>> daos = new HashMap<>(); // Liste des DAO
    protected boolean running = false;

    /**
     * Cherche le DAO correspondant et le retourne
     * @param persistentClass la class cible
     * @param persistenceUnitName le SGBD cible
     * @return le DAO corréspondant à la class demandé
     */
    public final DAO<?> getDao(Class<?> persistentClass, String persistenceUnitName) {
        // Cherche le DAO correspondant à la classe peristante, s'il n'existe pas, il est créé, ajouté à la liste, puis retourné
        return daos.computeIfAbsent(persistentClass,  _ -> DAO.of(persistentClass, persistenceUnitName));
    }

    public final void requestStop() {
        this.running = false;
    }

}
