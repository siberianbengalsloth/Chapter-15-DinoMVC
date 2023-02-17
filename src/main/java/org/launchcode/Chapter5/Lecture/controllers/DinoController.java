package org.launchcode.Chapter5.Lecture.controllers;


import org.launchcode.Chapter5.Lecture.data.DinoData;
import org.launchcode.Chapter5.Lecture.data.DinosaurRepository;
import org.launchcode.Chapter5.Lecture.models.Dinosaur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;



@Controller
@RequestMapping("dino")

public class DinoController {

    // create a DinosaurRepo field so that we can access all of the CRUD methods to save/read data from the DB
    // private type variableName;
    @Autowired
    private DinosaurRepository dinosaurRepository;

    // create a method that handles get requests at the /dino path
    @GetMapping
    public String dino(Model model) {

        // pass in a list of all of the dinos in our data layer

        model.addAttribute("allDinos", dinosaurRepository.findAll());

        return "dino/index";
    }


    @GetMapping("add")
    public String dinoForm(Model model) {
        model.addAttribute("dinosaur", new Dinosaur());
        return "dino/add";
    }

    @PostMapping("add")
    public String processDinoForm(Model model, @ModelAttribute @Valid Dinosaur newDino, Errors errors) {
        // now that we have the three necessary pieces of data from the form, we must create a Dinosaur object

        // Dinosaur newDino = new Dinosaur(species, diet, aquatic);
        // ↑ This line was needed when the parameters were (String species, String diet, String aquatic)
        // but now that we have @ModelAttribute Dinosaur newDino in the parameter, this line is no longer needed
        // as @ModelAttribute creates a newDino in one line

        // now that we are validating the POST request data with model validation, we need to check the data is
        // passing using this errors object before adding the dino to the allDinos list
        if(errors.hasErrors()) {
            //if the page has any errors (meaning all the @Validations we added in the Dinosaur Model is being
            // triggered or not being met) then it will return the page to dino/add
        // return "dino/add";

        // Add an error message shown to the user so they know exactly what went wrong
        model.addAttribute("errorMsg", "The species must contain at least 3 characters!");

        return "dino/add";
        }


        // add the newDino to the list!
        DinoData.addDino(newDino);

        // model.addAttribute("allDinos", DinoData.getAllDinos());

        // return "dino/index";
        return "redirect:";
        // return "redirect:"; << This will send a get request and redirect us to the homepage instead of going to dino/index
        // if using "redirect" the line 67 model.addAttribute needs to be taken out
        // this is nice because we don't want the method to manually render a page - if we redirect, it will go to
        // the main page that has a method which is rendering the information already. Thus we don't need to add attribute to model here

    }


}
