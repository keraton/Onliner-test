package com.github.keraton;

public class TaumBday {


    static int taumBday(int b, int w, int bc, int wc, int z) {

        int minResult = (b * bc) + (w * wc);
        if (bc > wc) {
            for (int i = 0; i<b ; i++) {
                int tempResult = (w * wc) + ((b-i)*wc) + (i*bc) + ((b-i)* z);
                if (tempResult < minResult) {
                    minResult = tempResult;
                }
            }
        }
        else {
            for (int i = 0; i<b ; i++) {
                int tempResult = (b * bc) + ((w-i)*bc) + (i*wc) + ((w-i)* z);
                if (tempResult < minResult) {
                    minResult = tempResult;
                }
            }

        }


        return minResult;
    }
}
