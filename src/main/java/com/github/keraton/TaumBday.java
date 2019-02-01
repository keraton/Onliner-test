package com.github.keraton;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

public class TaumBday {


    static long taumBday(int b, int w, int bc, int wc, int z) {
        BigInteger minResult = valueOf(Long.MAX_VALUE);
        if (bc > wc) {
            for (int i=0; i<=b ; i++) {
                BigInteger r1 = valueOf(b-i)
                        .multiply(valueOf(wc));
                BigInteger r2 = valueOf(i)
                        .multiply(valueOf(bc));
                BigInteger r3 = valueOf(i)
                        .multiply(valueOf(bc));
                BigInteger tempResult = r1.add(r2).add(r3);
                if (tempResult.subtract(minResult).longValue() < 0 ) {
                    minResult = tempResult;
                }
            }

            minResult = minResult.add(valueOf(w).multiply(valueOf(wc)));
        }
        else {
            for (int i=0; i<=w ; i++) {
                BigInteger r1 = valueOf(w-i)
                        .multiply(valueOf(bc));
                BigInteger r2 = valueOf(i)
                        .multiply(valueOf(wc));
                BigInteger r3 = valueOf(i)
                        .multiply(valueOf(wc));
                BigInteger tempResult = r1.add(r2).add(r3);
                if (tempResult.subtract(minResult).longValue() < 0 ) {
                    minResult = tempResult;
                }
            }

            minResult = minResult.add(valueOf(w).multiply(valueOf(wc)));

        }


        return  minResult.longValue();
    }
}
