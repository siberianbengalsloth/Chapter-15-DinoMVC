package org.launchcode.Chapter5.Lecture.controllers;


import org.launchcode.Chapter5.Lecture.models.DinoEgg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("egg")
public class EggController {

    // create a method that is designed to display the egg/index view
    @GetMapping
    public String egg() {
        return "egg/index";
    }


    // create a method that will display the egg addition form
    @GetMapping("add")
    public String displayAddEggForm(Model model) {
        model.addAttribute("dinoEgg", new DinoEgg());
        return "egg/add";
    }

    // create a post method that will redirect the user to the add form
    @PostMapping("add")
    public String processAddEggForm() {
        return "";
    }

}
