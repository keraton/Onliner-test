package com.github.keraton.oneliner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static com.github.keraton.oneliner.OneLinerAssertions.assertThat;
import static com.github.keraton.oneliner.OneLinerExtension.*;


@DisplayName("One line Test")
@ExtendWith(OneLinerExtension.class)
class OneLinerExtensionTest {

    @TestFactory
    List<DynamicNode> rspec_style(){
        // RSpec style
        describe("RSpec Style",

                context("Create a context",
                        it("run test", assertThat(1).isEqualTo(1)),
                        it("run another test", assertThat(1).isEqualTo(1))),


                context("Create another context",
                        it("run test", assertThat(1).isEqualTo(1)),
                        it("run another test", assertThat(1).isEqualTo(1)))

        );

        return nodes();
    }

    @TestFactory
    List<DynamicNode> test_assertObject() {

        // Test Mode
        Object o = new Object();
        Object n = null;
        test("isEqualTo", assertThat(o).isEqualTo(o));
        test("isNotEqualTo", assertThat(o).isNotEqual(new Object()));
        test("isNull", assertThat(n).isNull());
        test("isNotNull", assertThat(o).isNotNull());
        test("isSameAs", assertThat(o).isSameAs(o));
        test("isNotSameAs", assertThat(o).isNotSameAs(n));
        test("isIn", assertThat(o).isIn(o, n));
        test("isNotIn", assertThat(o).isNotIn(new Object(), new Object()));
        test("isInstanceOf", assertThat(o).isInstanceOf(Object.class));
        test("isInstanceOfAny", assertThat(o).isInstanceOfAny(Object.class));
        test("isNotInstanceOf", assertThat("").isNotInstanceOf(Integer.class));
        test("isNotExactlyInstanceOf", assertThat("").isNotExactlyInstanceOf(Integer.class));
        test("isNotInstanceOfAny", assertThat("").isNotInstanceOfAny(Integer.class));
        test("hasSameClassAs", assertThat("").hasSameClassAs("test"));
        test("doesNotHaveSameClassAs", assertThat("").doesNotHaveSameClassAs(1));

        return nodes();
    }

    @TestFactory
    List<DynamicNode> test_assertBoolean() {

        test("isTrue", assertThat(true).isTrue());
        test("isFalse", assertThat(false).isFalse());
        test("isEqualTo", assertThat(true).isEqualTo(true));
        test("isFalse", assertThat(false).isNotEqualTo(true));

        test("isFalse", assertThat(Boolean.FALSE).isNotEqualTo(true));
        test("isTrue", assertThat(Boolean.TRUE).isEqualTo(true));

        return nodes();
    }

    @TestFactory
    List<DynamicNode> test_assertInteger() {

        test("isEqualTo", assertThat(1).isEqualTo(1));
        test("isNotEqualTo", assertThat(1).isNotEqualTo(2));
        test("isZero", assertThat(0).isZero());
        test("isOne", assertThat(1).isOne());
        test("isNotZero", assertThat(1).isNotZero());
        test("isPositive", assertThat(1).isPositive());
        test("isNotPositive", assertThat(-1).isNotPositive());
        test("isNegative", assertThat(-1).isNegative());
        test("isNotNegative", assertThat(1).isNotNegative());
        test("isLessThan", assertThat(1).isLessThan(2));
        test("isLessThanOrEqual", assertThat(1).isLessThanOrEqualTo(1));
        test("isGreaterThan", assertThat(1).isGreaterThan(0));
        test("isGreaterThanOrEqualTo", assertThat(1).isGreaterThanOrEqualTo(1));
        test("isBetween", assertThat(1).isBetween(1, 5));
        test("isStrictlyBetween", assertThat(2).isStrictlyBetween(1, 5));

        test("multipleAssertions", assertThat(1)
                .isEqualTo(1)
                .isOne()
                .isNotNegative()
                .isNotZero()
        );

        test("isZero", assertThat(Integer.valueOf(0)).isZero());
        testFail("isZero", assertThat(1).isZero());

        return nodes();
    }

    @TestFactory
    List<DynamicNode> test_assertString() {

        test("multipleAssertions", assertThat("a")
                                                .isGreaterThanOrEqualTo("a")
                                                .isEqualTo("a")
                                                .isLessThan("b"));

        test("isLessThan", assertThat("a").isLessThan("b"));
        test("isLessThanOrEqualTo", assertThat("a").isLessThanOrEqualTo("a"));
        test("isGreaterThan", assertThat("b").isGreaterThan("a"));
        test("isGreaterThanOrEqualTo", assertThat("a").isGreaterThanOrEqualTo("a"));
        test("isBetween", assertThat("a").isBetween("a", "b"));
        test("isStrictlyBetween", assertThat("b").isStrictlyBetween("a", "c"));
        test("isNotEmpty", assertThat("a")
                                .isNotEmpty()
                                .isEqualTo("a")
                                .isLessThan("b"));
        test("isEmpty", assertThat("").isEmpty());


        test("isNullOrEmpty", assertThat((String) null).isNullOrEmpty());
        test("isNullOrEmpty", assertThat("").isNullOrEmpty());
        test("isBlank", assertThat("    ").isBlank());
        test("contains", assertThat("abcde").contains("d","a"));
        test("containsSequence", assertThat("abcde").containsSequence("a","b"));
        test("containsIgnoringCase", assertThat("ABCD").containsIgnoringCase("a"));

        testFail("isNotEmpty", assertThat("").isNotEmpty());
        testFail("isLessThan", assertThat("c").isLessThan("b"));


        return nodes();
    }



}
