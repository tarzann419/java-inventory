# Project README

This Java application follows the pattern of Domain -> Repository -> Services -> Controller for managing drink-related information.

## 1. Domain

### Drink.java

The `Drink` class represents the domain model for drinks.

```java
package com.inventory.demo.domain;

// imports...

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define other properties (e.g., name, type, company, etc.)

    // Define getters and setters

}
```

## 2. Repository

### DrinkRepository.java

The `DrinkRepository` interface extends JpaRepository for basic CRUD operations and can include custom queries.

```java
package com.inventory.demo.repository;

import com.inventory.demo.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    // Custom queries can be added here if needed
}
```

## 3. Services

### DrinkService.java

The `DrinkService` interface defines methods to interact with drinks.

```java
package com.inventory.demo.services;

import com.inventory.demo.domain.Drink;

import java.util.List;

public interface DrinkService {
    Drink saveDrink(Drink drink);
    Drink getDrinkById(long id);
    List<Drink> getAllDrinks();
    Drink updateDrinkById(Drink drink);
    void deleteDrinkById(long id);
}
```

### DrinkServiceImpl.java

The `DrinkServiceImpl` class implements the `DrinkService` interface and provides the logic for the defined methods.

```java
package com.inventory.demo.services;

import com.inventory.demo.domain.Drink;
import com.inventory.demo.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    @Override
    public Drink getDrinkById(long id) {
        Optional<Drink> drink = drinkRepository.findById(id);

        if (drink.isPresent()) {
            return drink.get();
        } else {
            throw new RuntimeException("Drink Not Found");
        }
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink updateDrinkById(Drink drink) {
        Optional<Drink> optionalDrink = drinkRepository.findById(drink.getId());

        if (optionalDrink.isPresent()) {
            Drink updateDrink = optionalDrink.get();
            // Update properties of the existing drink with the provided drink
            // ...

            return drinkRepository.save(updateDrink);
        } else {
            throw new RuntimeException("Drink does not exist");
        }
    }

    @Override
    public void deleteDrinkById(long id) {
        drinkRepository.deleteById(id);
    }
}
```

## 4. Controller

### DrinkController.java

The `api/DrinkAPIController` class handles API endpoints related to drinks.

```java
@RestController
@RequestMapping("/api/drinks")
public class DrinkAPIController {

    @Autowired
    private DrinkService drinkService;

    @PostMapping
    public ResponseEntity<Drink> saveDrink(@RequestBody Drink drink) {
        return new ResponseEntity<>(drinkService.saveDrink(drink), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable long id) {
        return new ResponseEntity<>(drinkService.getDrinkById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks() {
        return new ResponseEntity<>(drinkService.getAllDrinks(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Drink> updateDrinkById(@RequestBody Drink drink) {
        return new ResponseEntity<>(drinkService.updateDrinkById(drink), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrinkById(@PathVariable long id) {
        drinkService.deleteDrinkById(id);
        return new ResponseEntity<>("Drink deleted successfully", HttpStatus.OK);
    }
}
```

