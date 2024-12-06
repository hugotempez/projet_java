package fr.itii25.tasks;

import fr.itii25.tasks.commands.Command;
import fr.itii25.tasks.events.EventListener;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Tache chargée de la pérsistance des données dans la base postgres
 * Elle est controlée par le menu
 */
public class ThreadRecepteur extends Task implements EventListener {

    LinkedBlockingQueue<Command> commands = new LinkedBlockingQueue<>(); // La queue des commandes


    @Override
    public void update(Command command) {
        if (command == null) {
            return;
        }
        commands.add(command);
    }

    /**
     * Redéfinition de la méthode run() de l'interface Runnable
     */
    @Override
    public void run() {
        this.running = true;

        while (this.running) {  //Tant que running est true
            try {
                // Attente de la prochaine commande disponible dans la Queue
                Command command = commands.take();
                command.execute(this); //Execution de la commande
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Fermeture du thread recepteur");
    }
}