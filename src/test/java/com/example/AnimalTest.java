package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    Animal animal;

    // Использую @BeforeEach для удобного расширения тестов при добавлении новых методов
    // + чтобы тесты (если их будет больше 1) были изолированы
    @BeforeEach
    void setUp() {
        animal = new Animal();
    }

    @Test
    void getFamilyWithoutArgsReturnsExpectedString() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}