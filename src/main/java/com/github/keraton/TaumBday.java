package com.github.keraton;

public class TaumBday {


    static int taumBday(int b, int w, int bc, int wc, int z) {
        int result1 = (b * bc) + (w * wc);

        int minResult = 0;
        if (bc > wc) {
            minResult = ((b+w) * wc ) + b * z;
        }
        else {
            minResult = ((b+w) * bc ) + w * z;
        }


        return Math.min(result1, minResult);
    }
}
