package com.github.keraton;

import org.junit.Test;

import static com.github.keraton.TaumBday.taumBday;
import static org.junit.Assert.assertEquals;

public class TaumBdayTest {

    @Test
    public void should() {
        // Given

        // When
        assertEquals(2, taumBday(1, 1, 1, 1, 1));
        assertEquals(5, taumBday(1, 1, 2, 3, 1));
        assertEquals(3, taumBday(1, 1, 10, 1, 1));
        assertEquals(3, taumBday(1, 1, 1, 10, 1));
        assertEquals(11, taumBday(1, 1, 1, 10, 10));

        // 10 + 40 = 50
        // 10 + 10 + 20 =
        assertEquals(40, taumBday(10, 10, 1, 4, 2));


        // Then

    }

}