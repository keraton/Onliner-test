package com.github.keraton;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

public class TaumBday {


    static long taumBday(int b, int w, int bc, int wc, int z) {
        int distance = 2;

        Index index = taumBdayWithDistance(b, w, bc, wc, z, distance, 0, 0);
        index = taumBdayWithDistance(b, w, bc, wc, z, 1, index.index, index.index + distance);



        return  index.minResult.longValue();
    }

    static class Index {
        BigInteger minResult;
        int index;
    }

    private static Index taumBdayWithDistance(int b, int w, int bc, int wc, int z, int distance, int start, int end) {
        BigInteger minResult = valueOf(Long.MAX_VALUE);
        int index = 0;

        if (bc > wc) {
            int realEnd = end == 0 ? b : Math.min(b, end);
            for (int i=start; i<=realEnd ; i=i+distance) {
                BigInteger tempResult = getBigInteger(b, bc, wc, z, i);

                if (tempResult.subtract(minResult).longValue() < 0 ) {
                    minResult = tempResult;
                    index = i;
                }
                else {
                    break;
                }

            }
            minResult = minResult.add(valueOf(w).multiply(valueOf(wc)));
        }
        else {
            int realEnd = end == 0 ? w : Math.min(w, end);
            for (int i=start; i<=realEnd ; i = i + distance) {
                BigInteger tempResult = getBigInteger(w, wc, bc, z, i);

                if (tempResult.subtract(minResult).longValue() < 0 ) {
                    minResult = tempResult;
                    index = i;
                }
                else {
                    break;
                }
            }

            minResult = minResult.add(valueOf(b).multiply(valueOf(bc)));

        }
        Index index1 = new Index();
        index1.index = index;
        index1.minResult = minResult;
        return index1;
    }

    private static BigInteger getBigInteger(int b, int bc, int wc, int z, int i) {
        BigInteger r1 = valueOf(b - i).multiply(valueOf(wc));
        BigInteger r2 = valueOf(i).multiply(valueOf(bc));
        BigInteger r3 = valueOf(b - i).multiply(valueOf(z));
        return r1.add(r2).add(r3);
    }
}
