package fr.itii25.tasks.events;

import fr.itii25.tasks.commands.Command;

public interface EventListener {
    void update(Command command);
}
