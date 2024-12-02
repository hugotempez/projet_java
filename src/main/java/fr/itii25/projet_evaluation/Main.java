package fr.itii25.projet_evaluation;

import fr.itii25.dao.DAO;
import fr.itii25.models.Film;
import fr.itii25.tasks.ThreadEmetteur;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ThreadEmetteur thread = new ThreadEmetteur();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}