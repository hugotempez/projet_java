package fr.itii25.dao;

import fr.itii25.models.Film;

import java.util.List;

public class FilmDAO extends DAO<Film>{
    @Override
    public Film find(long id) {
        return null;
    }

    @Override
    public List<Film> findAll() {
        return List.of();
    }

    @Override
    public boolean create(Film obj) {
        return false;
    }

    @Override
    public boolean update(Film obj) {
        return false;
    }

    @Override
    public boolean delete(Film obj) {
        return false;
    }
}
