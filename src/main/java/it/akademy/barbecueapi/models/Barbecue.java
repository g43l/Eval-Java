package it.akademy.barbecueapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity

public class Barbecue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private int streetNumber;
    private String streetName;
    private String city;
    private String country;

//    @JsonBackReference(value = "bbq-person")
//    @OneToMany
//    private List<Person> people;
//
//    @JsonBackReference(value = "bbq-Meat")
//    @OneToMany
//    private Meat meat;

    public Barbecue() {}

    public Barbecue(LocalDate date, int streetNumber, String streetName, String city, String country) {
        this.date = date;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
//        this.people = new ArrayList<>();
//        this.meats = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}