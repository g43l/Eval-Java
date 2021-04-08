package it.akademy.barbecueapi.controllers;

import it.akademy.barbecueapi.dao.BarbecueDao;
import it.akademy.barbecueapi.models.Barbecue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/barbecues")

public class BarbecueController {

    private final BarbecueDao barbecueDao;
//    private final PersonDao personDao;
//    private final MeatDao meatDao;

    @Autowired
    public BarbecueController(BarbecueDao barbecueDao) {    //TODO: Rajouter Person et Meat quand ils seront créés
        this.barbecueDao = barbecueDao;
    }

    @GetMapping
    public ResponseEntity<List<Barbecue>> getAllBarbecues() {
        List<Barbecue> barbecues = barbecueDao.findAll();
        return new ResponseEntity<>(barbecues, HttpStatus.OK);
    }
}
