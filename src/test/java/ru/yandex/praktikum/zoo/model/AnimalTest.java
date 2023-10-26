package ru.yandex.praktikum.zoo.model;

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
        animal = new Animal();
    }

    @Parameterized.Parameters(name = ("{index}: {0}"))
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения") },
                { "Хищник", List.of("Животные", "Птицы", "Рыба") }
        });
    }

    @Test
    public void getFood() throws Exception {
        assertEquals(food, animal.getFood(ANIMAL_KIND));
    }

    @Test
    public void getFoodException() {
        String animalKind = this.ANIMAL_KIND + "-почти";
        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    public void getFamily() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}
