package com.github.keraton;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
    public void subscribe_with_errors() {
        // Given
        List<Integer> elements = new ArrayList<>();
        List<Throwable> errors = new ArrayList<>();

        // When
        Flux.just(1, 2, 3)
            .log()
            .map(this::errorMapping)
            .subscribe(elements::add, errors::add, () -> System.out.println("completed"));

        // Then
        assertThat(elements).containsExactly(1); // 3 is ignored
        assertThat(errors).hasSize(1);
    }

    @Test
    public void subscribe_fallback() {
        // Given
        List<Integer> elements = new ArrayList<>();
        List<Throwable> errors = new ArrayList<>();

        // When
        Flux.just(1, 2, 3)
            .log()
            .map(this::errorMapping)
            //.retry(1)
            //.onErrorReturn(0)
            .onErrorResumeWith(e -> Flux.just(0))
            .subscribe(elements::add, errors::add, () -> System.out.println("completed"));


        // Then
        assertThat(elements).containsExactly(1, 0); // 3 is ignored
        assertThat(errors).hasSize(0);
    }

    private Integer errorMapping(Integer i) {
        // Error is a terminal event, you need to prevent it
        System.out.println("Common !");
        if (i == 2)
            throw new RuntimeException("2");
        return i;
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