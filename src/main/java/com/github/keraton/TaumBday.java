package com.github.keraton;

public class TaumBday {


    static long taumBday(int b, int w, int bc, int wc, int z) {
        long minResult = Long.MAX_VALUE;
        if (bc > wc) {
            for (int i=0; i<=b ; i++) {
                long tempResult = (w*wc) + ((b-i)*wc) + (i*bc) + ((b-i)* z);
                if (tempResult < minResult) {
                    minResult = tempResult;
                }
            }
        }
        else {
            for (int i = 0; i<=w ; i++) {
                long tempResult = (b*bc) + ((w-i)*bc) + (i*wc) + ((w-i)* z);
                if (tempResult < minResult) {
                    minResult = tempResult;
                }
            }

        }


        return  minResult;
    }
}
