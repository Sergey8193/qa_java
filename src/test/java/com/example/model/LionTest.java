package com.example.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    Feline feline;
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

    @Before
    public void getFeline() {
        feline = new Feline();
    }

    @Test
    public void getFamily() {
        runTestOf("getFamily","Кошачьи");
    }

    @Test
    public void getKittens() {
        runTestOf("getKittens", KITTENS_NUMBER.toString());
    }

    @Test
    public void getSound() {
        runTestOf("getSound", "Мяу");
    }

    @Test
    public void doesHaveMane() {
        runTestOf("doesHaveMane", HAS_MANE.toString());
    }

    @Test
    public void getFood() {
        runTestOf("getFood", FOOD.toString());
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
}
