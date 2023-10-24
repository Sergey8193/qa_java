package com.example.model;

import java.util.List;

public class Cat {

    Feline feline;

    public Cat(Feline feline) {
        this.feline = feline;
    }

    public String getFamily() { return feline.getFamily(); }
    public String getSound() { return feline.getSound(); }
    public int getKittens() { return feline.getKittens(); }
    public List<String> getFood() throws Exception { return feline.getFood(); }
}
