package com.github.keraton;

import org.junit.Test;

import static com.github.keraton.AcmTeam.acmTeam;
import static org.assertj.core.api.Assertions.assertThat;

public class AcmTeamTest {

    @Test
    public void should () {
        assertThat(acmTeam("1", "1")).containsExactly(1, 1);

    }

}