package com.example.model;

import com.example.contracts.AnimalCapabilities;

import java.util.List;

public abstract class Animal implements AnimalCapabilities {

    public List<String> getFood(String animalKind) throws Exception {
        List <String> list = List.of("Трава", "Различные растения", "Животные", "Птицы", "Рыбы");

        switch (animalKind) {
            case "Травоядные":
                return list.subList(0, 2);
            case "Хищные":
                return list.subList(2, 5);
            case "Всеядные":
                return list;
            default:
                throw new Exception("Неизвестный вид животных: используйте значения 'Травоядные', 'Хищные' или 'Всеядные'");
        }
    }

    public String getFamily() {
        return "Различают семейcтва: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
}
