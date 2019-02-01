package com.github.keraton;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

public class TaumBday {


    static long taumBday(int b, int w, int bc, int wc, int z) {
        BigInteger minResult = valueOf(Long.MAX_VALUE);
        if (bc > wc) {
            for (int i=b; i>=0 ; i--) {
                BigInteger tempResult = getBigInteger(b, bc, wc, z, i);


                if (tempResult.subtract(minResult).longValue() < 0 ) {
                    minResult = tempResult;
                }
                else {
                    break;
                }


            }

            minResult = minResult.add(valueOf(w).multiply(valueOf(wc)));
        }
        else {
            for (int i=w; i>=0 ; i--) {
                BigInteger tempResult = getBigInteger(w, wc, bc, z, i);

                if (tempResult.subtract(minResult).longValue() < 0 ) {
                    minResult = tempResult;
                }
                else {
                    break;
                }
            }

            minResult = minResult.add(valueOf(b).multiply(valueOf(bc)));

        }


        return  minResult.longValue();
    }

    private static BigInteger getBigInteger(int b, int bc, int wc, int z, int i) {
        BigInteger r1 = valueOf(b - i).multiply(valueOf(wc));
        BigInteger r2 = valueOf(i).multiply(valueOf(bc));
        BigInteger r3 = valueOf(b - i).multiply(valueOf(z));
        return r1.add(r2).add(r3);
    }
}
