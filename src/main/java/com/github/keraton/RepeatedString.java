package com.github.keraton;

public class RepeatedString {

    // Complete the repeatedString function below.
    // 1 < |s| < 100
    // 1 <= n <= 10^12
    // The letter a
    static long repeatedString(String s, long n) {
        int length = s.length();

        long multiply = Math.max(1, n / length);

        long count = 0;
        long rest = n - (length * multiply);
        if (rest > 0) {
            count = getCount(s, rest);
        }
        
        count += getCount(s,  n) * multiply;

        return count;
    }

    private static long getCount(String s,  long rest) {
        long count = 0;
        for (int i = 0; i < Math.min(s.length(), rest); i++) {
            if (s.charAt(i) == 'a')
                count++;
        }
        return count;
    }

}
