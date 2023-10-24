package com.example.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {
    private Cat cat;

    @Before
    public void getCat() {
        Feline feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void getFamily() {
        String expected = "Кошачьи";
        assertEquals(expected, cat.getFamily());
    }

    @Test
    public void getSound() {
        String expected = "Мяу";
        assertEquals(expected, cat.getSound());
    }

    @Test
    public void getKittens() {
        int expected = 1;
        assertEquals(expected, cat.getKittens());
    }

    @Test
    public void getFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        assertEquals(expected, cat.getFood());
    }
}
