package com.example.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class LionMockitoTest {
    Lion lion;

    @Mock
    Feline feline;

    @Before
    public void getLion() throws Exception {
        lion = new Lion(feline,"Самец");
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыбы"));
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыбы");
        List<String> actual = lion.getFood();
        Mockito.verify(feline, times(1)).getFood();
        assertEquals( expected, actual);
    }

    @Test
    public void getFamily() {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        String expected = "Кошачьи";
        String actual = lion.getFamily();
        Mockito.verify(feline, times(1)).getFamily();
        assertEquals( expected, actual);
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Integer expected = 1;
        Integer actual = lion.getKittens();
        Mockito.verify(feline, times(1)).getKittens();
        assertEquals( expected, actual);
    }

    @Test
    public void getSound() {
        Mockito.when(feline.getSound()).thenReturn("Мяу");
        String expected = "Мяу";
        String actual = lion.getSound();
        Mockito.verify(feline, times(1)).getSound();
        assertEquals( expected, actual);
    }

    @Test
    public void LionSexException() {
        String sex = "Оно";
        String expectedExceptionMessage = "Используйте допустимые значения пола животного: 'Самeц' или 'Самка'";
        Exception exception = assertThrows(Exception.class, () ->  new Lion(feline, sex));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }
}
