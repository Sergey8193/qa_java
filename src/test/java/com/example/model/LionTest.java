package com.example.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Method;
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
                { "Самец", true, 1, List.of("Животные", "Птицы", "Рыбы") },
                { "Самка", false, 1 , List.of("Животные", "Птицы", "Рыбы")},
        });
    }

    @Before
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void LionSexException() {
        String expectedExceptionMessage = "Используйте допустимые значения пола животного: 'Самeц' или 'Самка'";
        Exception exception = assertThrows(
                Exception.class,
                () -> lion = new Lion(feline, new StringBuilder(SEX).reverse().toString())
        );
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    private void runTestOf(String methodName, String expected) {
        Method method;
        String actual;

        try {
            lion = new Lion(feline, SEX);
            method = lion.getClass().getMethod(methodName);
            actual = method.invoke(lion).toString();
            assertEquals(expected, actual);
        }
        catch(Exception e) { fail(); }
    }

    @Test
    public void doesHaveMane() {
        runTestOf("doesHaveMane", HAS_MANE.toString());
    }

    @Test
    public void getFamily() {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        runTestOf("getFamily","Кошачьи");
        Mockito.verify(feline, times(1)).getFamily();
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_NUMBER);
        runTestOf("getKittens", KITTENS_NUMBER.toString());
        Mockito.verify(feline, times(1)).getKittens();
    }

    @Test
    public void getSound() {
        Mockito.when(feline.getSound()).thenReturn("Мяу");
        runTestOf("getSound", "Мяу");
        Mockito.verify(feline, times(1)).getSound();
    }


    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood()).thenReturn(FOOD);
        runTestOf("getFood", FOOD.toString());
        Mockito.verify(feline, times(1)).getFood();
    }
}
