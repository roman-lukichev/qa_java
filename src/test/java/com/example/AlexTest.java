package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    Alex alex;

    @Mock
    Feline feline;

    // Использую @BeforeEach, чтобы тесты были изолированы
    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    void getKittensWithoutArgsReturn0() {
        alex.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(0);
    }

    @Test
    void getFriendsWithoutArgsReturnListOfFriends() {
        var expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    void getPlaceOfLivingWithoutArgsReturnNYZoo() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
}