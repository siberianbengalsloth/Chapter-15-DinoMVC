package org.launchcode.Chapter5.Lecture.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DinoEgg {
@Id
@GeneratedValue

    private int id;
    private int sizeInches;
    private int weightKg;
    private String dateLaid;

    // ▼ alongside these normal fields, a field that establishes the relationship between the eggs and dino class must be included
    @ManyToOne
private Dinosaur dinosaur; // this must be a field because this instance of an egg will be linked to a dinosaur

    public DinoEgg() {} // model classes always MUST have an empty constructor! To make model validation and model binding work!
    // to be able to use model.addAttribute

    public DinoEgg(int sizeInches, int weightKg, String dateLaid) {
        this.sizeInches = sizeInches;
        this.weightKg = weightKg;
        this.dateLaid = dateLaid;
    }

    public int getId() {
        return id;
    }

    public int getSizeInches() {
        return sizeInches;
    }

    public void setSizeInches(int sizeInches) {
        this.sizeInches = sizeInches;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public String getDateLaid() {
        return dateLaid;
    }

    public void setDateLaid(String dateLaid) {
        this.dateLaid = dateLaid;
    }
}
