package fr.itii25.tasks;

import fr.itii25.commands.Command;

import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<EventListener>> listeners;

    public void subscribe (String eventType, EventListener listener){
        listeners.get(eventType).add(listener);
    }

    public void unsubscribe (String eventType, EventListener listener){
        listeners.get(eventType).remove(listener);
    }

    public void notify (String eventType, Command command){
        listeners.get(eventType).forEach(EventListener::update);
    }
}
