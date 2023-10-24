package com.example.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalTest {
    private Animal animal;
    private final String ANIMAL_KIND;
    List <String> food;

    public AnimalTest(String animalKind, List <String> food) {
        this.ANIMAL_KIND = animalKind;
        this.food = food;
    }

    @Before
    public void getAnimal() {
        animal = new Feline();
    }

    @Parameterized.Parameters(name = ("{index}: {0}"))
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Травоядные", List.of("Трава", "Различные растения") },
                { "Хищные", List.of("Животные", "Птицы", "Рыбы") },
                { "Всеядные", List.of("Трава", "Различные растения", "Животные", "Птицы", "Рыбы") }
        });
    }

    @Test
    public void getFood() throws Exception {
        assertEquals(food, animal.getFood(ANIMAL_KIND));
    }

    @Test
    public void getFoodException() {
        String animalKind = this.ANIMAL_KIND + "-почти";
        String expectedExceptionMessage = "Неизвестный вид животных: используйте значения 'Травоядные', 'Хищные' или 'Всеядные'";
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    public void getFamily() {
    String expected = "Различают семейcтва: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    Feline feline = (Feline) animal;
    assertEquals(expected, feline.getFamily("Животные"));
    }
}
