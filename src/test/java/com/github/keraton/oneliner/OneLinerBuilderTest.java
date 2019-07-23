package com.github.keraton.oneliner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static com.github.keraton.oneliner.OneLinerBuilder.oneLinerBuilder;
import static com.github.keraton.oneliner.OneLinerExtension.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("One line Test")
class OneLinerBuilderTest {


    @TestFactory
    List<DynamicNode> buildBDDTest() {

        // Lambda mode
        // BDD Style
        return oneLinerBuilder().
                given("one line test",
                        when("run",
                                then("do equal ", () -> assertThat(1).isEqualTo(1)),
                                then("2nd dynamic test", () -> assertThat(1).isEqualTo(1))),

                        when("run again",
                                then("do equal ", () -> assertThat(1).isEqualTo(1)),
                                then("2nd dynamic test", () -> assertThat(1).isEqualTo(1)))
                ).
                given("one line test without when",
                        then("do equal ", () -> assertThat(1).isEqualTo(1)),
                        then("2nd dynamic test", () -> assertThat(1).isEqualTo(1))
                ).
                build();
    }

    @TestFactory
    List<DynamicNode> buildRSpecTest() {

        // Lambda mode
        // BDD Style
        return oneLinerBuilder().
                describe("one line test",
                        context("I would like to test with fun",
                                it
                                        ("do equal ", () -> assertThat(1).isEqualTo(1)),
                                it("2nd dynamic test", () -> assertThat(1).isEqualTo(1))),

                        context("This is so much fun",
                                it("do equal ", () -> assertThat(1).isEqualTo(1)),
                                it("2nd dynamic test", () -> assertThat(1).isEqualTo(1)))
                ).
                build();
    }
    @TestFactory
    List<DynamicNode> buildTest() {

        // Lambda mode
        // BDD Style
        return oneLinerBuilder().
                should("1 = 1", () -> assertThat(1).isEqualTo(1)).
                should("2 = 2", () -> assertThat(2).isEqualTo(2)).
                test("1 = 1", () -> assertThat(1).isBetween(0, 2)).
                build();
    }
}
