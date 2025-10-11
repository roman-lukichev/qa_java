package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    Feline feline;

    // Использую @BeforeEach, чтобы тесты были изолированы
    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    void eatMeatWithoutArgsReturnsPredatorFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void getFamilyWithoutArgsReturnsCatFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutArgsReturns1() {
        assertEquals(1, feline.getKittens());
    }
}