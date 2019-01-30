package com.github.keraton;

import java.util.HashMap;
import java.util.Map;

public class EqualizeArray {

    static int equalizeArray(int... arr) {
        Map<Integer, Integer> alreadyIn = new HashMap<>();
        for (int ar : arr) {
            if (!alreadyIn.containsKey(ar)) {
                alreadyIn.put(ar, 1);
            }
            else {
                Integer counter = alreadyIn.get(ar);
                alreadyIn.put(ar, counter + 1);
            }
        }
        int total = arr.length;
        Integer maxNumber = alreadyIn.values().stream().max(Integer::compareTo).get();
        return total - maxNumber;
    }
}
