package com.inventory.demo.controller.api;

import com.inventory.demo.domain.Drink;
import com.inventory.demo.repository.DrinkRepository;
import com.inventory.demo.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DrinkAPIController {
    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    DrinkService drinkService;

    @RequestMapping("/drinks")
    @GetMapping("/drinks")
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return ResponseEntity.ok().body(drinkRepository.findAll());
    }

    @RequestMapping("/drinks/{id}")
    @GetMapping
    public ResponseEntity<Drink> getDrinkById(@PathVariable long id){
        return ResponseEntity.ok().body(drinkService.getDrinkById(id));
    }

    @PostMapping("/drink")
    public ResponseEntity<Drink> createDrink(@RequestBody Drink drink){
        return ResponseEntity.ok().body(drinkService.saveDrink(drink));
    }

    @PutMapping("/drink/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable long id, @RequestBody Drink drink){
        return ResponseEntity.ok().body(drinkService.updateDrinkById(drink));
    }

    @DeleteMapping("/drink/{id}")
    public HttpStatus deleteDrink(@PathVariable long id){
        drinkService.deleteDrinkById(id);
        return HttpStatus.OK;
    }
}
