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
            count = getCount(s, count, length);

            long div = tempLength / s.length();
            count = count * div;

            tempLength = tempLength - (s.length() * div);

        } while (tempLength > 0);
        

        return count;
    }

    private static long getCount(String s, long count, long length) {
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a')
                count++;
        }
        return count;
    }

}
