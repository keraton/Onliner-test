package com.github.keraton;

import org.junit.jupiter.api.Test;

import static com.github.keraton.AcmTeam.acmTeam;
import static org.assertj.core.api.Assertions.assertThat;

class AcmTeamTest {

    @Test
    void should() {
        assertThat(acmTeam("1", "1")).containsExactly(1, 1);
        assertThat(acmTeam("11", "11")).containsExactly(2, 1);
        assertThat(acmTeam("10", "11")).containsExactly(2, 1);
        assertThat(acmTeam("10", "10")).containsExactly(1, 1);

        assertThat(acmTeam("1", "1", "1")).containsExactly(1, 3);
        assertThat(acmTeam("10101", "11100", "11010", "00101")).containsExactly(5, 2);
        // 1,2 1,3 2,3
    }

}