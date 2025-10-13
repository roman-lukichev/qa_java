package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LionTest {

    Lion lion;

    @Mock
    Feline feline;

    // Использую @BeforeEach, чтобы тесты были изолированы
    @BeforeEach
    void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    void getKittensCallsFelineGetKittensOnce() {
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    void getFoodCallsFelineGetFoodOnce() throws Exception{
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}