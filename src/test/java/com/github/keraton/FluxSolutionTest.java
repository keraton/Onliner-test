package com.github.keraton;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FluxSolution {

    @Test
    public void should () {
        // Given
        List<Integer> elements = new ArrayList<>();

        // When
        Flux.just(1, 2, 3)
            .log()
            .subscribe(elements::add);

        // Then
        assertThat(elements).containsExactly(1, 2, 3);

    }

}