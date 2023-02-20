package org.launchcode.Chapter5.Lecture.controllers;


import org.launchcode.Chapter5.Lecture.data.DinoEggRepository;
import org.launchcode.Chapter5.Lecture.data.DinosaurRepository;
import org.launchcode.Chapter5.Lecture.models.DinoEgg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("egg")
public class EggController {

    @Autowired
    private DinosaurRepository dinosaurRepository;
    // we need these at the top of the controller so that it's available throughout the controller
    @Autowired
    private DinoEggRepository dinoEggRepository;

    // create a method that is designed to display the egg/index view
    @GetMapping
    public String egg() {
        return "egg/index";
    }


    // create a method that will display the egg addition form
    @GetMapping("add")
    public String displayAddEggForm(Model model) {
        model.addAttribute("dinoEgg", new DinoEgg());
        model.addAttribute("allDinos", dinosaurRepository.findAll());
        return "egg/add";
    }

    // create a post method that will redirect the user to the add form
    @PostMapping("add")
    public String processAddEggForm(Model model, @ModelAttribute @Valid DinoEgg newDinoEgg,
    Errors errors) {

        // check to see if the data in the request is valid for creating a new DinoEgg object. If it's not valid, send the user
        //back to the egg/add page and show the form again

        if (errors.hasErrors()) {

            model.addAttribute("dinoEgg", new DinoEgg());
            model.addAttribute("allDinos", dinosaurRepository.findAll());
            return "egg/add";
        }


        // if the data is determined to be valid, the DinoEgg object needs to be saved in the database

        dinoEggRepository.save(newDinoEgg);
        return "redirect:";
    }

}
