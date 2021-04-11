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


}