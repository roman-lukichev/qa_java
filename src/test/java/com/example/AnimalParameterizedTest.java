package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnimalParameterizedTest {

    Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal();
    }

    private static Stream<Arguments> animalFoodProvider() {
        return Stream.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения")),
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
        );
    }

    @ParameterizedTest(name = "getFood with '{0}' returns {1}")
    @MethodSource("animalFoodProvider")
    void getFoodWithValidParams(String animalKind, List<String> expected) throws Exception {
        assertEquals(expected, animal.getFood(animalKind));
    }

    private static Stream<String> invalidAnimalKindProvider () {
        return Stream.of(null, "", " ", "Неизвестен");
    }

    @ParameterizedTest(name = "getFood with '{0}' returns Exception")
    @MethodSource("invalidAnimalKindProvider")
    void getFoodWithInvalidParams(String animalKind) {
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }
}