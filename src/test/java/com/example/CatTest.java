package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    Cat cat;

    @Mock
    Feline feline;

    // Использую @BeforeEach, чтобы тесты были изолированы
    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    void getSoundWithoutArgsReturnMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodCallsEatMeatOnce() throws Exception{
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}