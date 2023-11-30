package com.inventory.demo.controller;


import com.inventory.demo.domain.Drink;
import com.inventory.demo.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("drinks", drinkService.getAllDrink());
        return "home";
    }

    @GetMapping("/showNewDrinkForm")
    public String showNewDrinkForm(Model model){
        Drink drink = new Drink();
        model.addAttribute("drink", drink);

        return "new_drink";
    }

    @PostMapping("/saveDrink")
    public String saveDrink(@ModelAttribute("drink") Drink drink, RedirectAttributes redirectAttributes){
        drinkService.saveDrink(drink);
        redirectAttributes.addFlashAttribute("message", "User added successfully");

        return "redirect:/";
    }
}
