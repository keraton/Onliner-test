package com.github.keraton;

import java.util.HashMap;
import java.util.Map;

public class EqualizeArray {

    static int equalizeArray(int... arr) {
        Map<Integer, Integer> alreadyIn = new HashMap<>();
        alreadyIn.put(arr[0], 1);
        for (int ar : arr) {
            if (!alreadyIn.containsKey(ar)) {
                alreadyIn.put(ar, 1);
            }
            else {
                Integer counter = alreadyIn.get(ar);
                alreadyIn.put(ar, ++counter);
            }
        }
        int total = alreadyIn.size();
        Integer maxNumber = alreadyIn.values().stream().max(Integer::compareTo).get();
        return total - 1;
    }
}
