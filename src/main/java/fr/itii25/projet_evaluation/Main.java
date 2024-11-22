package fr.itii25.projet_evaluation;

import fr.itii25.dao.DAO;
import fr.itii25.models.Film;

public class Main {
    public static void main(String[] args) {
        var dao = DAO.of(Film.class);
    }
}