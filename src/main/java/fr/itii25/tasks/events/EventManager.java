package fr.itii25.tasks.events;

import fr.itii25.tasks.commands.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<EventListener>> listeners;

    public EventManager() {
        listeners = new HashMap<String, List<EventListener>>();
    }

    public void subscribe (String eventType, EventListener listener){
        listeners.computeIfAbsent(eventType, _ -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe (String eventType, EventListener listener){
        listeners.get(eventType).remove(listener);
    }

    public void notify (String eventType, Command command){
        List<EventListener> listenersToTopic = listeners.get(eventType);
        if (listenersToTopic == null) return;

        listenersToTopic.forEach(listener -> listener.update(command));
    }
}
