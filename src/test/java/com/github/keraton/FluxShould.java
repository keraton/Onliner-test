package com.github.keraton;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FluxShould {

    @Test
    public void subscribe() {
        // Given
        List<Integer> elements = new ArrayList<>();

        // When
        Flux.just(1, 2, 3)
            .log()
            .subscribe(elements::add);

        // Then
        assertThat(elements).containsExactly(1, 2, 3);
    }

    @Test
    public void filter () {
        // Given
        List<Integer> elements = new ArrayList<>();

        // When
        Flux.just(1, 2, 3)
                .log()
                .filter(i -> i % 2 == 0)
                .log()
                .subscribe(elements::add);

        // Then
        assertThat(elements).containsExactly(2);
    }

    @Test
    public void map () {
        // Given
        List<Integer> elements = new ArrayList<>();

        // When
        Flux.just(1, 2, 3)
                .log()
                .map(i -> i * 2)
                .log()
                .subscribe(elements::add);

        // Then
        assertThat(elements).containsExactly(2, 4, 6);
    }

}