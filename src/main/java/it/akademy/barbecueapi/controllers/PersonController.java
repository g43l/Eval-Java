package it.akademy.barbecueapi.controllers;


import it.akademy.barbecueapi.dao.PersonDao;
import it.akademy.barbecueapi.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")

public class PersonController {


    private final PersonDao personDao;


    @Autowired
    public PersonController(PersonDao personDao) {    //TODO: Rajouter Person et Food quand ils seront créés
        this.personDao = personDao;
//        this.foodDao = foodDao;
        //       this.barbecueDao = barbecueDao;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        List <Person> people = personDao.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        Person person = personDao.findById(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<Person>> getAllPeopleByFirstName(@PathVariable String firstName) {
        List<Person> people = personDao.findAllByFirstName(firstName);
        if (people == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<Person>> getAllPeopleByLastName(@PathVariable String lastName) {
        List<Person> people = personDao.findAllByLastName(lastName);
        if (people == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person person1 = personDao.save(person);
        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> putPerson(@PathVariable int id, @RequestBody Person person) {
        Person modifiedPerson = personDao.findById(id);

        if (modifiedPerson == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        person.setId(id);
        modifiedPerson = personDao.save(person);
        return new ResponseEntity<>(modifiedPerson, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> deletePerson(@PathVariable int id) {  //<?> ==> remplace un void car rien à renvoyer
        Person person = personDao.findById(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



