package com.github.keraton;

public class AcmTeam {

    static int[] acmTeam(String... topics) {
        String topic1 = topics[0];
        String topic2 = topics[1];

        int size = topic1.length();
        int maxTopics = 0;
        for (int i=0; i<size; i++) {
            if (topic1.charAt(i) == topic2.charAt(i)) {
                maxTopics++;
            }
        }

        int maxPersons = 1;
        return new int[] {maxTopics, maxPersons};
    }
}
