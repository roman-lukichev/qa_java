package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LionParameterizedTest {

    @ParameterizedTest(name = "doesHaveMane for Lion({0}) return mane = {1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeForSexReturnExpected(String sex, boolean expected) throws Exception{
        Lion lion = new Lion(sex, new Feline());
        assertEquals(expected, lion.doesHaveMane());
    }

    private static Stream<String> sexProvider () {
        return Stream.of(null, "", " ", "Неизвестен");
    }

    @ParameterizedTest(name = "lionConstructor with ({0}) return Exception")
    @MethodSource("sexProvider")
    void lionConstructorWithInvalidParamsReturnException (String sex) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(sex, new Feline()));
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }
}