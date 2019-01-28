package com.github.keraton;

import org.junit.Test;

import static com.github.keraton.RepeatedString.repeatedString;
import static org.junit.Assert.assertEquals;

public class RepeatedStringTest {

    @Test
    public void should_repeat_string () {
        // When
        assertEquals(1, repeatedString("a", 1));
        assertEquals(2, repeatedString("aa", 2));
        assertEquals(1, repeatedString("ab", 2));
        assertEquals(3, repeatedString("aaa", 3));
        assertEquals(2, repeatedString("aaa", 2));
        assertEquals(4, repeatedString("aaa", 4));
        assertEquals(5, repeatedString("aaa", 5));
        assertEquals(3, repeatedString("aba", 4));

    }

}