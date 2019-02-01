package com.github.keraton;

public class TaumBday {


    static int taumBday(int b, int w, int bc, int wc, int z) {
        int result1 = (b * bc) + (w * wc);
        int result2 = ( (b+w) * wc ) + b * z;
        return Math.min(result1, result2);
    }
}
