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
        assertEquals(expected, feline.getFamily());
    }

    @Test
    public void getFamilyWithAncestorParam() {
        String expected = "Различают семейcтва: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, feline.getFamily("Животные"));
    }

    @Test
    public void getFamilyWithWrongAncestorParam() {
        String expected = "Кошачьи";
        assertEquals(expected, feline.getFamily("Рыбы"));
    }

    @Test
    public void getSound() {
        String expected = "Мяу";
        assertEquals(expected, feline.getSound());
    }

    @Test
    public void getKittensWith1() {
        int expected = 1;
        assertEquals(expected, feline.getKittens(1));
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWith1() {
        feline.getKittens();
        verify(feline, times(1)).getKittens(1);
    }

    @Test
    public void getFood() {
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        try { assertEquals(expected, feline.getFood()); }
        catch(Exception e) { fail(); }
    }
}
