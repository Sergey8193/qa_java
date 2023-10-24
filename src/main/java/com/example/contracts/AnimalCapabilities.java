package com.example.contracts;

import java.util.List;

public interface AnimalCapabilities {
    List<String> getFood(String animalKind) throws Exception;
    String getFamily();
}
