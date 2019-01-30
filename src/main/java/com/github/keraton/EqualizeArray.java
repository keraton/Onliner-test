package com.github.keraton;

public class EqualizeArray {

    static int equalizeArray(int... arr) {
        int diff = 0;
        int temp = arr[0];
        for (int ar : arr) {
            if (temp != ar) {
                diff++;
            }
        }
        return diff;
    }
}
