package com.example.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionAlexTest {
    private LionAlex alex;

    @Before
    public void getLionAlex() throws Exception {
        Feline feline = new Feline();
        alex = new LionAlex(feline);
    }

    @Test
    public void doesHaveMane() {
        boolean expected = true;
        assertEquals(expected, alex.doesHaveMane());
    }

    @Test
    public void getSound() {
        String expected = "Мяу";
        assertEquals(expected, alex.getSound());
    }

    @Test
    public void getKittens() {
        int expected = 0;
        assertEquals(expected, alex.getKittens());
    }

    @Test
    public void getFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        assertEquals(expected, alex.getFood());
    }

    @Test
    public void getFriends() {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void getPlaceOfLiving() {
        String expected = "Нью-Йоркский Зоопарк";
        assertEquals(expected, alex.getPlaceOfLiving());
    }
}
