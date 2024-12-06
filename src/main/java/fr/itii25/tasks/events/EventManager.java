package fr.itii25.tasks.events;

import fr.itii25.tasks.commands.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implémente de la partie publisher du design pattern Observer
 */
public class EventManager {
    private Map<String, List<EventListener>> listeners; // Liste des listeners

    public EventManager() {
        listeners = new HashMap<String, List<EventListener>>();
    }

    /**
     * Permet de s'abonner à un type d'évennement
     * @param eventType type de l'évennement
     * @param listener "écouteur" des évennement
     */
    public void subscribe (String eventType, EventListener listener){
        if (eventType == null || eventType.isEmpty()) {
            System.out.println("Impossible de s'abonner, le type d'evenement est incorrect");
            return;
        }

        if (listener == null) {
            System.out.println("Impossible de s'abonner, le listener est incorrect");
            return;
        }
        listeners.computeIfAbsent(eventType, _ -> new ArrayList<>()).add(listener);
    }

    /**
     * Permet de se désabonner d'un type d'évennement
     * @param eventType type de l'évennement
     * @param listener "écouteur" des évennement
     */
    public void unsubscribe (String eventType, EventListener listener){
        listeners.get(eventType).remove(listener);
    }

    /**
     * Notifier les listeners d'un évennement
     * @param eventType type de l'évennement
     * @param command la commande qui est a éxecuté
     */
    public void notify (String eventType, Command command){
        if (eventType == null || eventType.isEmpty()) {
            System.out.println("Impossible de notifier l'evenement, Event type incorrect");
        }

        if (command == null) {
            System.out.println("Impossible de notifier l'evenement, commande incorrecte");
            return;
        }

        List<EventListener> listenersToTopic = listeners.get(eventType);
        if (listenersToTopic == null) return;

        listenersToTopic.forEach(listener -> listener.update(command));
    }
}
