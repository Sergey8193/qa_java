package ru.yandex.praktikum.zoo.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(Parameterized.class)
public class LionTest {

    private AutoCloseable closeable;
    Feline feline = mock(Feline.class);
    Lion lion;

    private final String SEX;
    private final Boolean HAS_MANE;
    private final Integer KITTENS_NUMBER;
    private final List<String> FOOD;

    public LionTest(String sex, boolean hasMane, int kittensNumber, List<String> food) {
        this.SEX = sex;
        this.HAS_MANE = hasMane;
        this.KITTENS_NUMBER = kittensNumber;
        this.FOOD = food;
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true, 1, List.of("Животные", "Птицы", "Рыба") },
                { "Самка", false, 1 , List.of("Животные", "Птицы", "Рыба") },
        });
    }

    @Before
    public void openMocks() throws Exception {
        closeable = MockitoAnnotations.openMocks(this);
        lion = new Lion(feline, SEX);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void lionSexException() {
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = assertThrows(
                Exception.class,
                () -> lion = new Lion(feline, new StringBuilder(SEX).reverse().toString())
        );
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    public void doesHaveMane() {
        boolean expected =  HAS_MANE;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_NUMBER);
        int expected =  KITTENS_NUMBER;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
        Mockito.verify(feline, times(1)).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(FOOD);
        List<String> actual = lion.getFood();
        assertEquals(FOOD, actual);
        Mockito.verify(feline, times(1)).getFood("Хищник");
    }
}
