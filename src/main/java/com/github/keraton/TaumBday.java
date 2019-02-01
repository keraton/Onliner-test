package com.github.keraton;

public class TaumBday {


    static long taumBday(int b, int w, int bc, int wc, int z) {
        long minResult = Long.MAX_VALUE;
        if (bc > wc) {
            if (z > bc) {
                minResult = (b*bc);
            }
            else {
                for (int i=0; i<=b ; i++) {
                    long tempResult = ((b-i)*wc) + (i*bc) + ((b-i)* z);
                    if (tempResult < minResult && tempResult >0) {
                        minResult = tempResult;
                    }
                }
            }

            minResult += (w*wc);
        }
        else {
            if (z > wc) {
                minResult = (w * wc);
            }
            else {
                for (int i = 0; i<=w ; i++) {
                    long tempResult = ((w-i)*bc) + (i*wc) + ((w-i)* z);
                    if (tempResult < minResult && tempResult >0) {
                        minResult = tempResult;
                    }
                }
            }
            minResult += (b*bc);

        }


        return  minResult;
    }
}
