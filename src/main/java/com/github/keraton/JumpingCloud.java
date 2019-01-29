package com.github.keraton;

public class JumpingCloud {

    static int jumpingOnClouds(int... c) {
        int loc = 0;
        int jump = 0;
        while (loc < c.length - 1) {
            loc++;
            jump++;
        }
        return jump;
    }
}
