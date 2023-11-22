package com.inventory.demo.controller.api;

import com.inventory.demo.domain.Drink;
import com.inventory.demo.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DrinkAPIController {
    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    DrinkRepository drinkService;

    @RequestMapping("/drinks")
    @GetMapping("/drinks")
    public ResponseEntity<List<Drink>> getAllDrinks(){
        return ResponseEntity.ok().body(drinkRepository.findAll());
    }
}
