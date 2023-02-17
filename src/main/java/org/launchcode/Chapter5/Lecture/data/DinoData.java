package org.launchcode.Chapter5.Lecture.data;

import org.launchcode.Chapter5.Lecture.models.Dinosaur;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DinoData {

    // create a list where all of the dinos can be stored that can be added to the application and the data type
    // is our model, which is Dinosaur!

    private static ArrayList<Dinosaur> allDinos = new ArrayList<>();

    // create a method that acts as a getter for this private ArrayList of allDinos
    public static ArrayList<Dinosaur> getAllDinos() {
        return allDinos;
    }

    // create a method that will add a newDino Dinosaurus object to the array list
    public static void addDino(Dinosaur dinosaur) {
    allDinos.add(dinosaur);
        }

}
