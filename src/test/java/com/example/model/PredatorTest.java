package com.example.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PredatorTest {
    final static Predator PREDATOR = new Feline();

    @Test
    public void eatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        assertEquals(expected, PREDATOR.eatMeat());
    }
}
