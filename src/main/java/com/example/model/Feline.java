package com.example.model;

import com.example.contracts.FelineCapabilities;

import java.util.List;

public class Feline extends Predator implements FelineCapabilities {

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public String getSound() {
        return "Мяу";
    }
    public List<String> getFood() throws Exception {return getFood("Хищные");}
    public String getFamily(String ancestor) { return ancestor.equals("Животные") ? super.getFamily() : getFamily(); }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}
