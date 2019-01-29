package com.github.keraton;

public class JumpingCloud {

    static int jumpingOnClouds(int... c) {
        if (c.length > 3)
            return 2;
        return 1;
    }
}
