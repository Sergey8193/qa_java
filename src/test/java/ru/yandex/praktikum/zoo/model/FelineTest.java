package ru.yandex.praktikum.zoo.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    public void getFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
        verify(feline, times(1)).getFamily();
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
}
