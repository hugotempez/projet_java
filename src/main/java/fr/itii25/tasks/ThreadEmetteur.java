package fr.itii25.tasks;

import fr.itii25.models.*;
import fr.itii25.models.dao.DB;
import fr.itii25.tasks.commands.PersistDataCommand;
import fr.itii25.models.dao.DAO;
import fr.itii25.tasks.commands.StopCommand;
import fr.itii25.tasks.events.EventListener;
import fr.itii25.tasks.events.EventManager;

import java.sql.SQLException;
import java.util.List;


public class ThreadEmetteur extends Task {

    private final EventManager eventManager;

    public ThreadEmetteur() {
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
            System.out.println("0. Tout");
            System.out.println("1. Actor\t\t2. Address");
            System.out.println("3. Category\t\t4. City");
            System.out.println("5. Country\t\t6. Customer");
            System.out.println("7. Films\t\t8. Inventory");
            System.out.println("9. Language\t\t10. Payment");
            System.out.println("11. Rental\t\t12. Staff");
            System.out.println("13. Store");

            String choix = System.console().readLine("Votre choix: ");

            switch (choix) {
                case "0" -> migrateAll();
                case "1" -> migrateActors();
                case "2" -> migrateAddress();
                case "3" -> migrateCategories();
                case "4" -> migrateCity();
                case "5" -> migrateCountry();
                case "6" -> migrateCustomer();
                case "7" -> migrateFilms();
                case "8" -> migrateInventory();
                case "9" -> migrateLanguage();
                case "10" -> migratePayment();
                case "11" -> migrateRental();
                case "12" -> migrateStaff();
                case "13" -> migrateStore();
                case "Q" -> {
                    running = false;
                    eventManager.notify("event", new StopCommand());
                }
                default -> throw new IllegalStateException("Unexpected value: " + choix);
            }
        }
    }

    private void migrateAll() {
        migrateActors();
        migrateAddress();
        migrateCategories();
        migrateCity();
        migrateCountry();
        migrateCustomer();
        migrateFilms();
        migrateInventory();
        migrateLanguage();
        migratePayment();
        migrateRental();
        migrateStaff();
        migrateStore();
    }

    private void migrateActors() {
        System.out.println("Migration de Actor...");
        try {
            DAO<Actor> dao = (DAO<Actor>) this.getDao(Actor.class, DB.SAKILA.getValue());
            List<Actor> actors = dao.findAll();
            actors.forEach(actor -> {
                eventManager.notify("event", new PersistDataCommand<Actor>(actor));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateAddress() {
        System.out.println("Migration de Address...");
        try {
            DAO<Address> dao = (DAO<Address>) this.getDao(Address.class, DB.SAKILA.getValue());
            List<Address> address = dao.findAll();
            address.forEach(addre -> {
                eventManager.notify("event", new PersistDataCommand<Address>(addre));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateCategories() {
        System.out.println("Migration de Category...");
        try {
            DAO<Category> dao = (DAO<Category>) this.getDao(Category.class, DB.SAKILA.getValue());
            List<Category> categories = dao.findAll();
            categories.forEach(category -> {
                eventManager.notify("event", new PersistDataCommand<Category>(category));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateCity() {
        System.out.println("Migration de City...");
        try {
            DAO<City> dao = (DAO<City>) this.getDao(City.class, DB.SAKILA.getValue());
            List<City> citys = dao.findAll();
            citys.forEach(city -> {
                eventManager.notify("event", new PersistDataCommand<City>(city));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateCountry() {
        System.out.println("Migration de Country...");
        try {
            DAO<Country> dao = (DAO<Country>) this.getDao(Country.class, DB.SAKILA.getValue());
            List<Country> countries = dao.findAll();
            countries.forEach(country -> {
                eventManager.notify("event", new PersistDataCommand<Country>(country));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateCustomer() {
        System.out.println("Migration de Customer...");
        try {
            DAO<Customer> dao = (DAO<Customer>) this.getDao(Customer.class, DB.SAKILA.getValue());
            List<Customer> customers = dao.findAll();
            customers.forEach(customer -> {
                eventManager.notify("event", new PersistDataCommand<Customer>(customer));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateFilms() {
        System.out.println("Migration de Film...");
        try {
            DAO<Film> dao = (DAO<Film>) this.getDao(Film.class, DB.SAKILA.getValue());
            List<Film> Films = dao.findAll();
            Films.forEach(film -> {
                eventManager.notify("event", new PersistDataCommand<Film>(film));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateInventory() {
        System.out.println("Migration de Inventory...");
        try {
            DAO<Inventory> dao = (DAO<Inventory>) this.getDao(Inventory.class, DB.SAKILA.getValue());
            List<Inventory> inventories = dao.findAll();
            inventories.forEach(inventory -> {
                eventManager.notify("event", new PersistDataCommand<Inventory>(inventory));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateLanguage() {
        System.out.println("Migration de Language...");
        try {
            DAO<Language> dao = (DAO<Language>) this.getDao(Language.class, DB.SAKILA.getValue());
            List<Language> languages = dao.findAll();
            languages.forEach(language -> {
                eventManager.notify("event", new PersistDataCommand<Language>(language));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migratePayment() {
        System.out.println("Migration de Payment...");
        try {
            DAO<Payment> dao = (DAO<Payment>) this.getDao(Payment.class, DB.SAKILA.getValue());
            List<Payment> payments = dao.findAll();
            payments.forEach(payment -> {
                eventManager.notify("event", new PersistDataCommand<Payment>(payment));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateRental() {
        System.out.println("Migration de Rental...");
        try {
            DAO<Rental> dao = (DAO<Rental>) this.getDao(Rental.class, DB.SAKILA.getValue());
            List<Rental> rentals = dao.findAll();
            rentals.forEach(rental -> {
                eventManager.notify("event", new PersistDataCommand<Rental>(rental));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateStaff() {
        System.out.println("Migration de Staff...");
        try {
            DAO<Staff> dao = (DAO<Staff>) this.getDao(Staff.class, DB.SAKILA.getValue());
            List<Staff> staffs = dao.findAll();
            staffs.forEach(staff -> {
                eventManager.notify("event", new PersistDataCommand<Staff>(staff));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void migrateStore() {
        System.out.println("Migration de Store...");
        try {
            DAO<Store> dao = (DAO<Store>) this.getDao(Store.class, DB.SAKILA.getValue());
            List<Store> stores = dao.findAll();
            stores.forEach(store -> {
                eventManager.notify("event", new PersistDataCommand<Store>(store));
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}