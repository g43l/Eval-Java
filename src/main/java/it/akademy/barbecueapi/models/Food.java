package it.akademy.barbecueapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private boolean cooked;

    @JsonManagedReference(value = "foods-people")
    @ManyToMany
    private List<Person> people;

    @JsonManagedReference(value = "foods-barbecues")
    @ManyToMany
    private List<Barbecue> barbecues;

    public Food(){}

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Barbecue> getBarbecues() {
        return barbecues;
    }

    public void setBarbecues(List<Barbecue> barbecues) {
        this.barbecues = barbecues;
    }

    public Food(String name, boolean cooked) {
        this.name = name;
        this.cooked = false;
        this.people = new ArrayList<>();
        this.barbecues = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCooked() {
        return cooked;
    }

    public void setCooked(boolean cooked) {
        this.cooked = cooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
