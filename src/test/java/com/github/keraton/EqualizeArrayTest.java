package com.github.keraton;

import org.junit.Test;

import static com.github.keraton.EqualizeArray.equalizeArray;
import static org.junit.Assert.assertEquals;

public class EqualizeArrayTest {

    @Test
    public void should () {
        // Given

        // When
        assertEquals(0, equalizeArray(1));
        assertEquals(0, equalizeArray(1, 1));
        assertEquals(1, equalizeArray(1, 2));
        assertEquals(2, equalizeArray(1, 2, 3));
        assertEquals(1, equalizeArray(1, 2, 1));
        //assertEquals(2, equalizeArray(1, 2, 1, 2));

        // Then

    }

}