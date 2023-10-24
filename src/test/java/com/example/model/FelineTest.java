package com.example.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void getFamilyWithNoParam() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
        verify(feline, times(1)).getFamily();
    }

    @Test
    public void getFamilyWithAncestorParam() {
        String expected = "Различают семейcтва: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = feline.getFamily("Животные");
        assertEquals(expected, actual);
        verify(feline, times(1)).getFamily("Животные");
    }

    @Test
    public void getFamilyWithWrongAncestorParam() {
        String expected = "Кошачьи";
        String actual = feline.getFamily("Рыбы");
        assertEquals(expected, actual);
        verify(feline, times(1)).getFamily("Рыбы");
    }

    @Test
    public void getSound() {
        String expected = "Мяу";
        String actual = feline.getSound();
        assertEquals(expected, actual);
        verify(feline, times(1)).getSound();
    }

    @Test
    public void getKittensWithParam() {
        int expected = 2;
        int actual = feline.getKittens(2);
        assertEquals(expected, actual);
        verify(feline, times(1)).getKittens(2);
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWith1() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
        verify(feline, times(1)).getKittens();
        verify(feline, times(1)).getKittens(1);
    }

    @Test
    public void getFood() {
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        try { assertEquals(expected, feline.getFood()); }
        catch(Exception e) { fail(); }
    }
}
