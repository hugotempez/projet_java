package fr.itii25.tasks.events;

import fr.itii25.tasks.commands.Command;

/**
 * Interface qui implémente la partie subscriber du design pattern Observer
 */
public interface EventListener {
    void update(Command command);
}
