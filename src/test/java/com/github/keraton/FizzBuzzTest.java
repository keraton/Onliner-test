package com.github.keraton;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void should () {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        assertEquals("1", fizzBuzz.getValue(1));
        assertEquals("Fizz", fizzBuzz.getValue(3));

    }
}