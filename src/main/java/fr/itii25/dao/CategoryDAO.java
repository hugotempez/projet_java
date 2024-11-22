package fr.itii25.dao;

import fr.itii25.models.Category;
import fr.itii25.models.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO extends DAO<Category> {

    private final Connection dbConnexion;

    public CategoryDAO(Connection dbConnexion) throws Exception {
        if (dbConnexion != null) {
            this.dbConnexion = dbConnexion;
        } else {
            throw new Exception();
        }
    }

    /**
     * @param id ID de l'objet à chercher
     * @return
     * @throws SQLException
     */
    @Override
    public Category find(long id) throws SQLException {
        String query = "SELECT * FROM category WHERE category_id = :?";
        PreparedStatement statement = dbConnexion.prepareStatement(query);
        statement.setInt(1, (int) id);
        ResultSet result = statement.executeQuery();
        statement.executeQuery(query);
        Category category = null;
        while (result.next()) {
            category = new Category(

                    );
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Category> findAll() {
        return List.of();
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean create(Category obj) {
        return false;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean update(Category obj) {
        return false;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Category obj) {
        return false;
    }
}
