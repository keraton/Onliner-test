package com.github.keraton;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void should() {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        assertEquals("1", fizzBuzz.getValue(1));
        assertEquals("Fizz", fizzBuzz.getValue(3));

    }
}