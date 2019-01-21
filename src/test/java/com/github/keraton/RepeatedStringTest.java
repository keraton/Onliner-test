package com.github.keraton;

import org.junit.Test;

import static com.github.keraton.RepeatedString.repeatedString;
import static org.junit.Assert.assertEquals;

public class RepeatedStringTest {

    @Test
    public void should () {
        // When
        assertEquals(1, repeatedString("a", 1));
        assertEquals(2, repeatedString("aba", 1));
        assertEquals(3, repeatedString("aaa", 1));


    }

}