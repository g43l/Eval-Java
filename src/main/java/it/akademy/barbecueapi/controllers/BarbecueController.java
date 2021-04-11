package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.BarbecueDao;
import it.akademy.barbecueapi.models.Barbecue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/barbecues")

public class BarbecueController {

    private final BarbecueDao barbecueDao;
//    private final PersonDao personDao;
//    private final FoodDao foodDao;

    @Autowired
    public BarbecueController(BarbecueDao barbecueDao) {    //TODO: Rajouter Person et Food quand ils seront créés
//        this.personDao = personDao;
//        this.foodDao = foodDao;
        this.barbecueDao = barbecueDao;
    }

    @GetMapping
    public ResponseEntity<List<Barbecue>> getAllBarbecues() {
        List<Barbecue> barbecues = barbecueDao.findAll();
        return new ResponseEntity<>(barbecues, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbecue> getBarbecueById(@PathVariable int id){
        Barbecue barbecue = barbecueDao.findById(id);
        if(barbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }

    @GetMapping("/city/{city}") // on rajoute city/ avant sinon ca ne marche pas avec "/{city}" , interférence avec le "/{id}"
    public ResponseEntity<List<Barbecue>> getAllBarbecuesByCity(@PathVariable String city){
        List<Barbecue> barbecues = barbecueDao.findAllByCity(city);
        if(barbecues == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barbecues, HttpStatus.OK);
    }

    @GetMapping("/country/{country}") // on rajoute country/ avant sinon ca ne marche pas avec "/{country}" , interférence avec le "/{id}"
    public ResponseEntity<List<Barbecue>> getAllBarbecuesByCountry(@PathVariable String country){
        List<Barbecue> barbecues = barbecueDao.findAllByCountry(country);
        if(barbecues == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barbecues, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Barbecue> createBarbecue(@RequestBody Barbecue barbecue) {
        Barbecue barbecue1 = barbecueDao.save(barbecue);
        return new ResponseEntity<>(barbecue1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barbecue> putBarbecue(@PathVariable int id, @RequestBody Barbecue barbecue){
        Barbecue modifiedBarbecue = barbecueDao.findById(id);

        if(modifiedBarbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        barbecue.setId(id);
        modifiedBarbecue = barbecueDao.save(barbecue);
        return new ResponseEntity<>(modifiedBarbecue, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteBarbecue(@PathVariable int id) {  //<?> ==> remplace un void car rien à renvoyer
        Barbecue barbecue = barbecueDao.findById(id);
        //si le Barbecue(id) n'existe pas :
        if (barbecue == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //si le barbecue(id) existe :
        barbecueDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
