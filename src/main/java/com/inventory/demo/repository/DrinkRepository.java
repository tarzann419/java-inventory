package com.inventory.demo.repository;

import com.inventory.demo.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

//    Drink(type); Long(id type)
//    you can also write your own custom query using: @Query("")
//    List<Drink> findDrinkByPriceGreaterThan(int price);

//    this repositpry helps us interact with our database
}
