package com.github.keraton;


import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void should () {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        String value = fizzBuzz.getValue(1);

        // Then
        Assert.assertEquals("1", value);

    }
}