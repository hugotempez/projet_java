package fr.itii25.tasks;

import fr.itii25.tasks.commands.Command;
import fr.itii25.tasks.events.EventListener;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadRecepteur extends Task implements EventListener {


    LinkedBlockingQueue<Command> commands = new LinkedBlockingQueue<>();

    @Override
    public void update(Command command) {
        commands.add(command);
    }

    @Override
    public void run() {
        this.running = true;

        while (this.running) {
            try {
                // Attente de la prochaine commande disponible dans la Queue
                Command command = commands.take();

                command.execute(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}