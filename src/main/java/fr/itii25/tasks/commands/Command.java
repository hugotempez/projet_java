package fr.itii25.tasks.commands;

import fr.itii25.tasks.Task;

/**
 * Interface représentant le design pattern Command
 */
public interface Command {

    void execute(Task task);

}
