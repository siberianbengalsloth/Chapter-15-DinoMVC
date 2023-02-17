package org.launchcode.Chapter5.Lecture.models;

import org.springframework.boot.convert.DataSizeUnit;

import javax.validation.constraints.*;

public class Dinosaur {

    private int id;
    private static int nextId = 1;

@NotBlank
@Size(min=3)
    private String species;
@NotNull
    private String diet;
@NotNull
    private String aquatic;

    public Dinosaur() {
        id = nextId;
        nextId++;
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

    public int getId() {
        return id;
    }


}
