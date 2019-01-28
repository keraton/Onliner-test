package com.github.keraton;

public class RepeatedString {

    // Complete the repeatedString function below.
    // 1 < |s| < 100
    // 1 <= n <= 10^12
    // The letter a
    static long repeatedString(String s, long n) {
        int count = 0;
        long length = Math.min(s.length(), n);
        for (int i=0; i<length; i++) {
            if (s.charAt(i) == 'a')
                count++;
        }

        if (s.length() < n) {
            count++;
        }
        return count;
    }

}
