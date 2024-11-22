package fr.itii25.models;

public class Film_category {
    private int film_id;
    private int category_id;
    private String last_update;

    public Film_category(int film_id, int category_id, String last_update) {
        this.film_id = film_id;
        this.category_id = category_id;
        this.last_update = last_update;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
