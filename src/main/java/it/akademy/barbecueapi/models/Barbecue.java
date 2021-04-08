package it.akademy.barbecueapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.util.ArrayList;

@Entity

public class Barbecue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private DateFormat date;
    private String address;
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

    public Barbecue(DateFormat date, String address, String city, String country) {
        this.date = date;
        this.address = address;
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

    public DateFormat getDate() {
        return date;
    }

    public void setDate(DateFormat date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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