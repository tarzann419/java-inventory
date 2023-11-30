package com.inventory.demo.controller;


import com.inventory.demo.domain.Drink;
import com.inventory.demo.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("pageTitle", "Add Drink");


        return "new_drink";
    }

    @PostMapping("/saveDrink")
    public String saveDrink(@ModelAttribute("drink") Drink drink, RedirectAttributes redirectAttributes){
        drinkService.saveDrink(drink);
        redirectAttributes.addFlashAttribute("message", "Drink updated successfully");

        return "redirect:/";
    }

    @GetMapping("/updateDrink/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
        try{
            Drink drink = drinkService.getDrinkById(id);
            model.addAttribute("drink", drink);
            model.addAttribute("pageTitle", "Edit Drink Id:" + id);

            return "new_drink";
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/";
        }
    }

    @PostMapping("/updateDrink")
    public String updateDrink(@ModelAttribute("drink") Drink drink, RedirectAttributes redirectAttributes){
        drinkService.saveDrink(drink);
        redirectAttributes.addFlashAttribute("message", "Drink updated successfully");

        return "redirect:/";
    }

    @GetMapping("deleteDrink/{id}")
    public String deleteDrink(@PathVariable long id, RedirectAttributes redirectAttributes){
        drinkService.deleteDrinkById(id);
        redirectAttributes.addFlashAttribute("message", "Drink Deleted successfully");

        return "redirect:/";
    }
}
