package com.github.keraton;

import java.util.HashSet;
import java.util.Set;

public class EqualizeArray {

    static int equalizeArray(int... arr) {
        int diff = 0;
        Set<Integer> alreadyIn = new HashSet<>();
        alreadyIn.add(arr[0]);
        for (int ar : arr) {
            if (!alreadyIn.contains(ar)) {
                alreadyIn.add(ar);
                diff++;
            }
        }
        return diff;
    }
}
