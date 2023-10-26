package ru.yandex.praktikum.zoo.contracts;

import java.util.List;

public interface AnimalCapabilities {
    List<String> getFood(String animalKind) throws Exception;
    String getFamily();
}
