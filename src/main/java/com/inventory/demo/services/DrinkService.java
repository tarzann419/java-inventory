package com.inventory.demo.services;

import com.inventory.demo.domain.Drink;

import java.util.List;

public interface DrinkService {
    Drink saveDrink(Drink drink);
    Drink getDrinkById(long id);

    Drink getDrinkById(Long id);

    List<Drink> getAllDrink();


    Drink updateDrinkById(long id);
    Drink deleteDrinkById(long id);
}
