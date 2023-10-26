package ru.yandex.praktikum.zoo;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import ru.yandex.praktikum.zoo.model.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AnimalTest.class,
        FelineTest.class,
        CatTest.class,
        LionTest.class,
        LionAlexTest.class
})
public class TestLauncher {
}
