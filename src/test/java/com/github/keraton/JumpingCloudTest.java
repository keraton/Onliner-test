package com.github.keraton;

import org.junit.Test;

import static com.github.keraton.JumpingCloud.jumpingOnClouds;
import static org.junit.Assert.assertEquals;

public class JumpingCloudTest {

    @Test
    public void should () {

        assertEquals(1, jumpingOnClouds(0, 0));
        assertEquals(1, jumpingOnClouds(0, 0, 0));
        assertEquals(2, jumpingOnClouds(0, 0, 0, 0));

    }

}