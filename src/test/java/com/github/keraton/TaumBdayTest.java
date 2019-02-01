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
        //assertEquals(18192035842l, taumBday(1, 1, 1, 10, 10));

        // (10 * 2) + (20 * 10) = 220
        // (10 * 2) + (20 * 2) + (9 * 20) = 240
        // (10 * 2) + (19 * 2) + (1 * 10) + (19 * 9)
        // (10 * 2) + (18 * 2) + (2 * 10) + (18 * 9)
        //assertEquals(40, taumBday(10, 20, 2, 10, 9));


        // Then

    }

}