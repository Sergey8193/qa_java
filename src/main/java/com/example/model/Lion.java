package com.example.model;

import java.util.List;

public class Lion {

    Feline feline;

    boolean hasMane;

    public Lion(Feline feline, String sex) throws Exception {

        this.feline = feline;

        switch (sex) {
            case "Самец":
                hasMane = true;
                break;
            case "Самка":
                hasMane = false;
                break;
            default:
                throw new Exception("Используйте допустимые значения пола животного: 'Самeц' или 'Самка'");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }
    public int getKittens() { return feline.getKittens(); }
    public List<String> getFood() throws Exception { return feline.getFood(); }
    public String getFamily() { return feline.getFamily(); }
    public String getSound() { return feline.getSound(); }
}
