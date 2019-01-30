package com.github.keraton;

import java.util.HashMap;
import java.util.Map;

public class EqualizeArray {

    static int equalizeArray(int... arr) {
        int diff = 0;
        Map<Integer, Integer> alreadyIn = new HashMap<>();
        alreadyIn.put(arr[0], 1);
        for (int ar : arr) {
            if (!alreadyIn.containsKey(ar)) {
                alreadyIn.put(ar, 1);
                diff++;
            }
            else {
                Integer counter = alreadyIn.get(ar);
                alreadyIn.put(ar, ++counter);
            }
        }
        return diff;
    }
}
