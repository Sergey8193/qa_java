package com.example.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void getCat() { cat = new Cat(feline); }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыбы"));
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыбы");
        List<String> actual = cat.getFood();
        assertEquals( expected, actual);
        Mockito.verify(feline, times(1)).getFood();
    }

    @Test
    public void getFamily() {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        String expected = "Кошачьи";
        String actual = cat.getFamily();
        assertEquals( expected, actual);
        Mockito.verify(feline, times(1)).getFamily();
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Integer expected = 1;
        Integer actual = cat.getKittens();
        assertEquals( expected, actual);
        Mockito.verify(feline, times(1)).getKittens();
    }

    @Test
    public void getSound() {
        Mockito.when(feline.getSound()).thenReturn("Мяу");
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals( expected, actual);
        Mockito.verify(feline, times(1)).getSound();
    }
}
