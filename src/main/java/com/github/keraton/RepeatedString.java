package com.github.keraton;

public class RepeatedString {

    // Complete the repeatedString function below.
    // 1 < |s| < 100
    // 1 <= n <= 10^12
    // The letter a
    static long repeatedString(String s, long n) {

        int count = 0;
        int charIndex = 0;

        while (charIndex < n) {
            int realIndex = charIndex % s.length();
            char c = s.charAt(realIndex);
            if (c == 'a')
                count++;
            charIndex++;
        }

        return count;
    }

}
