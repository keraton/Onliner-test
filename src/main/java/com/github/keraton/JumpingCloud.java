package com.github.keraton;

public class JumpingCloud {

    static int jumpingOnClouds(int... c) {
        int loc = 0;
        int jump = 0;
        int arrival = c.length - 1;
        while (loc < arrival) {
            loc += 2;
            if (loc < arrival && c[loc] == 1) {
                loc--;
            }
            jump++;
        }
        return jump;
    }
}
