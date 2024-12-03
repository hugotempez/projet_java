package fr.itii25.tasks;

import fr.itii25.tasks.commands.Command;
import fr.itii25.tasks.commands.PersistDataCommand;
import fr.itii25.models.dao.DAO;
import fr.itii25.models.Actor;
import fr.itii25.models.Category;
import fr.itii25.models.Film;
import fr.itii25.tasks.commands.StopCommand;
import fr.itii25.tasks.events.EventListener;
import fr.itii25.tasks.events.EventManager;

import java.sql.SQLException;
import java.util.List;


public class ThreadEmetteur extends Task {
    private DAO<Actor> daoActor;
    private DAO<Category> daoCategory;
    private DAO<Film> daoFilm;
    private EventManager eventManager;

    public ThreadEmetteur() {
        daoActor = DAO.of(Actor.class, "input_sakila");
        daoCategory = DAO.of(Category.class, "input_sakila");
        daoFilm = DAO.of(Film.class, "input_sakila");
        eventManager = new EventManager();
    }

    public void subscribe(String eventType, EventListener listener) {
        eventManager.subscribe(eventType, listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        eventManager.unsubscribe(eventType, listener);
    }

    @Override
    public void run() {
        this.running = true;

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
                case "Q" -> {
                    running = false;
                    eventManager.notify("event", new StopCommand());
                }
                default -> throw new IllegalStateException("Unexpected value: " + choix);
            }
        }
    }

    public void migrateActors() {
        System.out.println("Migration de Actor...");
        try {
            List<Actor> actors = daoActor.findAll();
            actors.forEach(actor -> {
                eventManager.notify("event", new PersistDataCommand<Actor>(actor));
            });
            eventManager.notify("event", new StopCommand());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void migrateCategories() {
        System.out.println("Migration de Category...");
        try {
            List<Category> categories = daoCategory.findAll();
            categories.forEach(category -> {
                eventManager.notify("Data", new PersistDataCommand<Category>(category));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void migrateFilms() {
        System.out.println("Migration de Film...");
        try {
            List<Film> Films = daoFilm.findAll();
            Films.forEach(film -> {
                eventManager.notify("Data", new PersistDataCommand<Film>(film));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}