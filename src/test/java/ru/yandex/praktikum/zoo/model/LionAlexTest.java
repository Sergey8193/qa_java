package ru.yandex.praktikum.zoo.model;

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
    public void getKittens() {
        int expected = 0;
        assertEquals(expected, alex.getKittens());
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
