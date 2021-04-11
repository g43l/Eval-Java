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
//    private final FoodDao meatDao;

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

    @PostMapping
    public ResponseEntity<Barbecue> createBarbecue(@RequestBody Barbecue barbecue) {
        Barbecue barbecue1 = barbecueDao.save(barbecue);
        return new ResponseEntity<>(barbecue1, HttpStatus.CREATED);
    }
}
