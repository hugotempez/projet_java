package fr.itii25.projet_evaluation;

import fr.itii25.dao.DAO;
import fr.itii25.models.Film;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DAO<Film> dao = DAO.of(Film.class);
        try {
            System.out.println(dao.findAll());
            Film film = dao.find(1);
            System.out.println(film);
            film.getActors().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}