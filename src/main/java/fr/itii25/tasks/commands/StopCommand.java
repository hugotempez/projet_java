package fr.itii25.tasks.commands;

import fr.itii25.tasks.Task;

/**
 * Implémentation du design pattern Command pour stoper l'échange de donnée
 */
public class StopCommand implements Command {

    /**
     *
     * @param task
     */
    @Override
    public void execute(Task task) {
        if (task == null) {
            System.out.println("Task is null");
            return;
        }
        System.out.println("Stop command");
        task.requestStop();
    }
}
