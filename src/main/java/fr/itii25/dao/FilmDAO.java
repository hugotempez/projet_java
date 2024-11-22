package fr.itii25.dao;

import fr.itii25.models.Film;

import java.sql.*;
import java.util.List;

public class FilmDAO extends DAO<Film> {

    private final Connection dbConnexion;

    public FilmDAO(Connection dbConnexion) throws Exception {
        if (dbConnexion != null) {
            this.dbConnexion = dbConnexion;
        } else {
            throw new Exception();
        }
    }

    @Override
    public Film find(long id) throws SQLException {
        String query = "SELECT * FROM actor WHERE actor_id = :?";
        PreparedStatement statement = dbConnexion.prepareStatement(query);
        statement.setInt(1, (int) id);
        ResultSet result = statement.executeQuery();
        statement.executeQuery(query);
        Film film = null;
        while (result.next()) {
            film = new Film(
                    result.getInt("film_id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getString("release_year"),
                    result.getInt("language_id"),
                    result.getInt("original_language_id"),
                    result.getInt("rental_duration"),
                    result.getDouble() int rental_rate, int length, double replacement_cost, String rating, String special_features, String last_update);
        }
        return null;
    }

    @Override
    public List<Film> findAll() {
        //SELECT * FROM actor
        return List.of();
    }

    @Override
    public boolean create(Film obj) {
        //INSERT INTO actor VALUE (:first_name, :last_name)
        //statement.setString(first_name, obj.first_name);
        //statement.setString(last_name, obj.last_name);
        return false;
    }

    @Override
    public boolean update(Film obj) {
        //UPDATE actor SET first_name = :first_name, last_name = :last_name
        //    WHERE actor_id = :actor_id;
        //statement.setString(first_name, obj.first_name);
        //statement.setString(last_name, obj.last_name);
        //statement.setString(actor_id, obj.actor_id);
        return false;
    }

    @Override
    public boolean delete(Film obj) {
        //DELETE FROM actor
        //    WHERE actor_id = :actor_id
        //statement.setString(actor_id, obj.actor_id);
        return false;
    }
}
