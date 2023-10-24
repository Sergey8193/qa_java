package com.example.model;

import com.example.contracts.PredatorCapabilities;

import java.util.List;

public abstract class Predator extends Animal implements PredatorCapabilities {

    public List<String> eatMeat() throws Exception {
        return getFood("Хищные");
    }
}
