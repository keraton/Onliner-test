package com.github.keraton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.keraton.RepeatedString.repeatedString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class RepeatedStringTest {


    static Stream<Arguments> source() {
        return Stream.of(
                of("compare ", 1, 2),
                of("compare 2", 3, 5)
        );
    }


    @DisplayName("Should repeat string")
    @ParameterizedTest(name = "\"{0}\"")
    @MethodSource("source")
    void should_repeat_string(String description, int a, int b) {
        // When
        assertEquals(1, repeatedString("a", 1));
        assertEquals(2, repeatedString("aa", 2));
        assertEquals(1, repeatedString("ab", 2));
        assertEquals(3, repeatedString("aaa", 3));
        assertEquals(2, repeatedString("aaa", 2));
        assertEquals(4, repeatedString("aaa", 4));
        assertEquals(5, repeatedString("aaa", 5));
        assertEquals(3, repeatedString("aba", 4));
        assertEquals(4, repeatedString("aba", 6));
        assertEquals(7, repeatedString("aaa", 7));
        assertEquals(8, repeatedString("aaa", 8));
        assertEquals(6, repeatedString("aba", 9));


    }

}