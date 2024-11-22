package fr.itii25.models;

public class Film_actor {
    private int actor_id;
    private int film_id;
    private String last_update;

    public Film_actor(int actor_id, int film_id, String last_update) {
        this.actor_id = actor_id;
        this.film_id = film_id;
        this.last_update = last_update;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
