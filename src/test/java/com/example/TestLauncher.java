package com.example;

import com.example.model.*;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
                AnimalTest.class,
                PredatorTest.class,
                FelineTest.class,
                CatTest.class,
                LionTest.class,
                LionMockitoTest.class,
                LionAlexTest.class
        })
public class TestLauncher {
}
