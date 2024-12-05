package fr.itii25.projet_evaluation;

import fr.itii25.tasks.ThreadEmetteur;
import fr.itii25.tasks.ThreadRecepteur;

public class Main {

    public static void main(String[] args) {
        ThreadEmetteur emetteur = new ThreadEmetteur();
        ThreadRecepteur recepteur = new ThreadRecepteur();

        emetteur.subscribe("event", recepteur); //Abonnement du recepteur aux evennements publiés par l'emetteur

        emetteur.start();
        recepteur.start();

        try {
            emetteur.join();
            recepteur.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}