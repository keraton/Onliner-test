package com.github.keraton;

public class RepeatedString {

    // Complete the repeatedString function below.
    // 1 < |s| < 100
    // 1 <= n <= 10^12
    // The letter a
    static long repeatedString(String s, long n) {
        long multiply = Math.max(1, n / s.length());
        long count = getCount(s,  n) * multiply;

        long rest = n - (s.length() * multiply);
        if (rest > 0) {
            count += getCount(s, rest);
        }

        return count;
    }

    private static long getCount(String s,  long rest) {
        return getCounts(s, Math.min(s.length(), rest));
    }

    private static long getCounts(String s, long length) {
        long count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a')
                count++;
        }
        return count;
    }

}
