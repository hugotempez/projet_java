package fr.itii25.tasks.commands;

import fr.itii25.tasks.Task;

public interface Command {

    void execute(Task task);

}
