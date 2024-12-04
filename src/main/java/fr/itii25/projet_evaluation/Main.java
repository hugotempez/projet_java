package fr.itii25.projet_evaluation;

import fr.itii25.tasks.ThreadEmetteur;
import fr.itii25.tasks.ThreadRecepteur;

//TODO: Migrations all ok sauf film_actor et film_category (relations ?)
//TODO: film_text ?
public class Main {
    public static void main(String[] args) {
        //TODO: Faire menu ici et créer threads à la volée ?
        ThreadEmetteur emetteur = new ThreadEmetteur();
        ThreadRecepteur recepteur = new ThreadRecepteur();

        emetteur.subscribe("event", recepteur);

        emetteur.start();
        recepteur.start();
        //TODO: utiliser des Locks pour gérer l'affichage ?
        try {
            emetteur.join();
            recepteur.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}