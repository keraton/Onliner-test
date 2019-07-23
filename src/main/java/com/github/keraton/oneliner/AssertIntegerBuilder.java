package com.github.keraton.oneliner;

import org.assertj.core.api.AbstractIntegerAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertIntegerBuilder extends AbstractAssertBuilder<AbstractIntegerAssert, AssertIntegerBuilder> {

    private List<Function<AbstractIntegerAssert, AbstractIntegerAssert>> assertComposition = new ArrayList<>();
    private AbstractIntegerAssert identity;

    public AssertIntegerBuilder(Integer i) {
        identity = assertThat(i);
        setSelf(this);
    }

    private void add(Function<AbstractIntegerAssert, AbstractIntegerAssert> t){
        assertComposition.add(t);
    }

    private AssertIntegerBuilder buildEqualTo(int equal) {
        add(a -> a.isEqualTo(equal));
        return this;
    }

    private AssertIntegerBuilder buildNotEqualTo(int i) {
        add(a -> a.isNotEqualTo(i));
        return this;
    }

    public AssertIntegerBuilder isEqualTo(int i) {
        return buildEqualTo(i);
    }

    public AssertIntegerBuilder isNotEqualTo(int i) {
        return buildNotEqualTo(i);
    }

    public AssertIntegerBuilder isZero() {
        return buildEqualTo(0);
    }

    public AssertIntegerBuilder isNotZero() {
        return buildNotEqualTo(0);
    }

    public AssertIntegerBuilder isOne() {
        return buildEqualTo(1);
    }

    public AssertIntegerBuilder isPositive() {
        add(AbstractIntegerAssert::isPositive);
        return this;
    }

    public AssertIntegerBuilder isNegative() {
        add(AbstractIntegerAssert::isNegative);
        return this;
    }

    public AssertIntegerBuilder isNotPositive() {
        add(AbstractIntegerAssert::isNotPositive);
        return this;
    }

    public AssertIntegerBuilder isNotNegative() {
        add(AbstractIntegerAssert::isNotNegative);
        return this;
    }

    public AssertIntegerBuilder isLessThan(int other) {
        add(a -> a.isLessThan(other));
        return this;
    }

    public AssertIntegerBuilder isLessThanOrEqualTo(int other) {
        add(a -> a.isLessThanOrEqualTo(other));
        return this;
    }

    public AssertIntegerBuilder isGreaterThan(int other) {
        add(a -> a.isGreaterThan(other));
        return this;
    }

    public AssertIntegerBuilder isGreaterThanOrEqualTo(int other) {
        add(a -> a.isGreaterThanOrEqualTo(other));
        return this;
    }

    public AssertIntegerBuilder isBetween(int start, int end) {
        add(a -> a.isBetween(start, end));
        return this;
    }

    public AssertIntegerBuilder isStrictlyBetween(int start, int end) {
        add(a -> a.isStrictlyBetween(start, end));
        return this;
    }

    @Override
    protected AbstractIntegerAssert getApply() {
        return assertComposition.stream()
                // This is a lazy evaluation
                .reduce(a -> a, (a, b) -> a.andThen(b))
                // Call it with apply
                .apply(identity);
    }
}
