package com.inventory.demo.services;

import com.inventory.demo.domain.Drink;
import com.inventory.demo.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService{
    @Autowired
    DrinkRepository drinkRepository;
    @Override
    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(drink);
    }


    @Override
    public Drink getDrinkById(long id) {
        Optional<Drink> drink = drinkRepository.findById(id);

        Drink emptyDrink = null;
        if (drink.isPresent()){
            emptyDrink = drink.get();
            return emptyDrink;
        } else {
            throw new RuntimeException("Drink Not Found");
        }
    }

    @Override
    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }


    @Override
    public Drink updateDrinkById(Drink drink) {
        Optional<Drink> optionalDrink = drinkRepository.findById(drink.getId());

        if (optionalDrink.isPresent()){
            Drink updateDrink = new Drink();
            updateDrink.setCapacity(drink.getCapacity());
            updateDrink.setColor(drink.getColor());
            updateDrink.setName(drink.getName());
            updateDrink.setType(drink.getType());
            updateDrink.setCompany(drink.getCompany());
            updateDrink.setId(drink.getId());
            updateDrink.setIngredients(drink.getIngredients());

            drinkRepository.save(updateDrink);
            return updateDrink;
        } else{
            throw new RuntimeException("Drink does not exist");
        }

    }

    @Override
    public void deleteDrinkById(long id) {
        drinkRepository.deleteById(id);
    }
}
