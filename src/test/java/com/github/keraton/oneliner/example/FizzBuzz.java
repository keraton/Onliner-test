package com.github.keraton.oneliner.example;

import com.github.keraton.oneliner.OneLinerAssertions;
import com.github.keraton.oneliner.OneLinerExtension;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static com.github.keraton.oneliner.OneLinerAssertions.assertThat;
import static com.github.keraton.oneliner.OneLinerExtension.nodes;
import static com.github.keraton.oneliner.OneLinerExtension.should;
import static com.github.keraton.oneliner.OneLinerExtension.test;


@ExtendWith(OneLinerExtension.class)
class FizzBuzzTest {

    static String fizzBuzz(int i) {
        if (i % 5 == 0 && i % 3 == 0)
            return "FizzBuzz";
        if (i % 3 == 0) {
            return "Fizz";
        }
        if (i % 5 == 0) {
            return "Buzz";
        }
        return Integer.toString(i);
    }

    @TestFactory
    List<DynamicNode> fizzBuzz() {
        test("Fizz for multiples of 3", assertThat(fizzBuzz(3)).isEqualTo("Fizz"));
        test("Buzz for multiples of 5", assertThat(fizzBuzz(5)).isEqualTo("Buzz"));
        test("FizzBuzz for multiple of 3 & 5", assertThat(fizzBuzz(15)).isEqualTo("FizzBuzz"));
        return nodes();
    }

}