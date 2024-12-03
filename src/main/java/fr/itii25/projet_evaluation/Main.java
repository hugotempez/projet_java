package fr.itii25.projet_evaluation;

import fr.itii25.tasks.ThreadEmetteur;
import fr.itii25.tasks.ThreadRecepteur;

//TODO: Pas d'insertion si table deja migré
//TODO: Si table vidé, pas de réinsertion avant redémarrage de l'appli
//TODO: Si migration de toute les tables, uniquement la première est effectué
//TODO: Une seul migration par éxecution de l'appli
//TODO: Migrations all ok sauf film_actor et film_category (nom table ?)
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