package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineParameterizedTest {

    Feline feline;

    // Использую @BeforeEach для удобного расширения тестов при добавлении новых методов
    // Использую @BeforeEach, чтобы тесты(если их будет больше 1) были изолированы
    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @ParameterizedTest(name = "getKittens with {0} returns {1}")
    @CsvSource({
            "-1, -1",
            "0, 0",
            "1, 1"
    })
    void getKittensWithParams(int kittensCount, int expected) {
        assertEquals(expected, feline.getKittens(kittensCount));
    }
}