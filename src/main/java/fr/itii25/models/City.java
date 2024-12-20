package fr.itii25.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}