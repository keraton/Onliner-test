package com.github.keraton;

import org.junit.Assert;
import org.junit.Test;

import static com.github.keraton.TaumBday.taumBday;
import static org.junit.Assert.assertEquals;

public class TaumBdayTest {

    @Test
    public void should() {
        // Given

        // When
        assertEquals(2, taumBday(1, 1, 1, 1, 1));

        // Then

    }

}