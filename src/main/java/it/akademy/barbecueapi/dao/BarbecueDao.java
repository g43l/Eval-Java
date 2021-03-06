package it.akademy.barbecueapi.dao;

import it.akademy.barbecueapi.models.Barbecue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbecueDao extends JpaRepository<Barbecue, Integer> {

    @Override
    List <Barbecue> findAll();

    Barbecue findById(int id);

    List <Barbecue> findAllByCity(String city);

    List <Barbecue> findAllByCountry(String country);

    Barbecue save(Barbecue barbecue);

    void deleteById(int id);
}
