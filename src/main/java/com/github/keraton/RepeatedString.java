package com.github.keraton;

public class RepeatedString {

    // Complete the repeatedString function below.
    // 1 < |s| < 100
    // 1 <= n <= 10^12
    // The letter a
    static long repeatedString(String s, long n) {
        long length = Math.min(s.length(), n);
        long count = getCount(s, length);

        long div = Math.max(1, n / s.length());
        count = count * div;

        long rest = n - (s.length() * div);

        if (rest > 0) {
            length = Math.min(s.length(), rest);
            count += getCount(s, length);

        }
        
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
