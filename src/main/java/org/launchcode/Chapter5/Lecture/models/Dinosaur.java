package org.launchcode.Chapter5.Lecture.models;

import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dinosaur extends AbstractEntity {
// @Id
// @GeneratedValue
    // private int id;
    // private static int nextId = 1; << no longer needed because we have @Id and @GeneratedValue - but those are not needed
    // either if the abstract entity is being extended

@NotBlank
@Size(min=3)
    private String species;
@NotNull
    private String diet;
@NotNull
    private String aquatic;

// ▼ alongside these normal fields, a field that establishes the relationship between the eggs and dino class must be included
    @OneToMany(mappedBy = "dinosaur") //match this mappedBy = "name" to the name of the field specified  in the @ManyToOne in the other related model class
private final List<DinoEgg> dinoEggs = new ArrayList<>(); // this links many eggs to this instance of one dinosaur

    public Dinosaur() {
       // id = nextId; << no longer needed because of @Id and @GeneratedValue
       //  nextId++; << no longer needed because of @Id and @GeneratedValue but this empty constructor is still needed
        // model classes always MUST have an empty constructor! To make model validation and model binding work!
    }

    public Dinosaur(String species, String diet, String aquatic) {
        this();
        this.species = species;
        this.diet = diet;
        this.aquatic = aquatic;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getAquatic() {
        return aquatic;
    }

    public void setAquatic(String aquatic) {
        this.aquatic = aquatic;
    }

//    public int getId() {        return id;    }


}
