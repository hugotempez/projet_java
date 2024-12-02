package fr.itii25.tasks;

import fr.itii25.commands.Command;
import fr.itii25.commands.DataCommand;
import fr.itii25.dao.DAO;
import fr.itii25.models.Actor;
import fr.itii25.models.Category;
import fr.itii25.models.Film;

import java.sql.SQLException;
import java.util.List;


public class ThreadEmetteur extends Thread {
    private DAO<Actor> daoActor;
    private DAO<Category> daoCategory;
    private DAO<Film> daoFilm;
    private EventManager eventManager;

    public void subscribe (String eventType, EventListener listener) {
        eventManager.subscribe(eventType, listener);
    }

    public void unsubscribe (String eventType, EventListener listener) {
        eventManager.unsubscribe(eventType, listener);
    }

    @Override
    public void run() {
        boolean running = true;

        daoActor = DAO.of(Actor.class);
        daoCategory = DAO.of(Category.class);
        daoFilm = DAO.of(Film.class);

        while (running) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Actor");
            System.out.println("2. Category");
            System.out.println("3. Film");

            String choix = System.console().readLine();

            Command command = null;
            switch (choix) {
                case "1" -> migrateActors();
                case "2" -> migrateCategories();
                case "3" -> migrateFilms();
                case "Q" -> running = false;
                default -> throw new IllegalStateException("Unexpected value: " + choix);
            }

        }
    }

    public void migrateActors() {
        System.out.println("Migration de Actor...");
        try {
            List<Actor> actors = daoActor.findAll();
            actors.forEach(actor -> {eventManager.notify("Data", new DataCommand(actor));});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void migrateCategories() {
        System.out.println("Migration de Category...");
        try {
            List<Category> categories = daoCategory.findAll();
            categories.forEach(category -> {eventManager.notify("Data", new DataCommand(category));});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void migrateFilms() {
        System.out.println("Migration de Film...");
        try {
            List<Film> Films = daoFilm.findAll();
            Films.forEach(film -> {eventManager.notify("Data", new DataCommand(film));});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}