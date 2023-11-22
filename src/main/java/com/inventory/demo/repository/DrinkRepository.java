package com.inventory.demo.repository;

import com.inventory.demo.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface DrinkRepository extends JpaRepository<Drink, Long> {
//    you can also write your own custom query using: @Query("")
//    List<Drink> findDrinkByPriceGreaterThan(int price);
}
