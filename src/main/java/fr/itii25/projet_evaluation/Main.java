package fr.itii25.projet_evaluation;

import fr.itii25.dao.DAO;
import fr.itii25.models.Actor;
import fr.itii25.models.Category;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DAO<Actor> dao = DAO.of(Actor.class);
        try {
            System.out.println(dao.findAll());
            System.out.println(dao.find(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DAO<Category> daoCategory = DAO.of(Category.class);
        try {
            System.out.println(daoCategory.findAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}