package com.github.keraton;

public class RepeatedString {

    // Complete the repeatedString function below.
    // 1 < |s| < 100
    // 1 <= n <= 10^12
    // The letter a
    static long repeatedString(String s, long n) {
        long count = 0;
        long tempLength = n;

        do {
            long length = Math.min(s.length(), tempLength);
            count = count + getCount(s, length);

            long div = Math.max(1, tempLength / s.length());
            count = count * div;

            tempLength = tempLength - (s.length() * div);

        } while (tempLength > 0);
        

        return count;
    }

    private static long getCount(String s, long length) {
        long count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a')
                count++;
        }
        return count;
    }

}
