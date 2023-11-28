package com.inventory.demo.services;

import com.inventory.demo.domain.Drink;

import java.util.List;

public interface DrinkService {

//    interfaces have no body because they are abstracts
    Drink saveDrink(Drink drink);
    Drink getDrinkById(long id);
    List<Drink> getAllDrink();
    Drink updateDrinkById(Drink drink);
    void deleteDrinkById(long id);
}
