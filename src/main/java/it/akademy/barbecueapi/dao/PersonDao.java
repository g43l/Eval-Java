package it.akademy.barbecueapi.dao;


import it.akademy.barbecueapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PersonDao extends JpaRepository<Person, Integer> {
    @Override
    List <Person> findAll();

    Person findById(int id);
    List <Person> findAllByFirstName(String firstName);
    List <Person> findAllByLastName(String lastName);


}