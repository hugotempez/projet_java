package fr.itii25.tasks.commands;

import fr.itii25.tasks.Task;

public class StopCommand implements Command {
    @Override
    public void execute(Task task) {
        System.out.println("Stop command");
        task.requestStop();
    }
}
