package com.github.keraton;

public class TaumBday {


    static int taumBday(int b, int w, int bc, int wc, int z) {
        int result1 = (b * bc) + (w * wc);

        int minResult = 0;
        if (bc > wc) {
            minResult = ((b+w) * wc ) + b * z;
            for (int i = 0; i<b ; i++) {
                int tempResult = (w * wc) + ((b-i)*wc) + (i*bc) + ((b-i)* z);
                if (tempResult < minResult) {
                    minResult = tempResult;
                }
            }
        }
        else {
            minResult = ((b+w) * bc ) + w * z;
            for (int i = 0; i<b ; i++) {
                int tempResult = (b * bc) + ((w-i)*bc) + (i*wc) + ((w-i)* z);
                if (tempResult < minResult) {
                    minResult = tempResult;
                }
            }

        }


        return Math.min(result1, minResult);
    }
}
