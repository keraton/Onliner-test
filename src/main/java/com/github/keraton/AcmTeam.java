package com.github.keraton;

public class AcmTeam {

    static int[] acmTeam(String... topics) {
        int maxTopics = 0;
        int maxPersons = 0;
        for (int i =0; i<topics.length; i++) {
            for (int j=0; j<topics.length; j++) {
                if (i != j) {
                    String topic1 = topics[i];
                    String topic2 = topics[j];

                    int maxTopicsTemp = getMaxTopics(topic1, topic2);
                    if (maxTopics < maxTopicsTemp) {
                        maxTopics = maxTopicsTemp;
                        maxPersons++;
                    }
                }
            }
        }


        return new int[] {maxTopics, maxPersons};
    }

    private static int getMaxTopics(String topic1, String topic2) {
        int size = topic1.length();
        int maxTopics = 0;
        for (int i=0; i<size; i++) {
            if (topic1.charAt(i) == '1' || topic2.charAt(i) == '1') {
                maxTopics++;
            }
        }
        return maxTopics;
    }
}
