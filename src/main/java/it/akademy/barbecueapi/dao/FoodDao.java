package it.akademy.barbecueapi.dao;



import it.akademy.barbecueapi.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FoodDao extends JpaRepository<Food, Integer> {
    @Override
    List<Food> findAll();
    Food findById(int id);
    List <Food> findAllByName(String name);

    Food save(Food food);

    void deleteById(int id);
}
