package fr.itii25.tasks.commands;

import fr.itii25.tasks.Task;

public class StopCommand implements Command {
    @Override
    public void execute(Task task) {
        task.requestStop();
    }
}
