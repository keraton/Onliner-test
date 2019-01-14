package com.github.keraton;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void should () {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        assertEquals("1", fizzBuzz.getValue(1));

    }
}