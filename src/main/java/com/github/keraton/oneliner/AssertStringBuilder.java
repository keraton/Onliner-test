package com.github.keraton.oneliner;

import org.assertj.core.api.AbstractStringAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertStringBuilder extends AbstractAssertCharSequenceBuilder<AbstractStringAssert, AssertStringBuilder> {

    private List<Function<AbstractStringAssert, AbstractStringAssert>> assertComposition = new ArrayList<>();
    private final AbstractStringAssert identity;

    public AssertStringBuilder(String s) {
        identity = assertThat(s);
        setSelf(this);
    }

    private void add(Function<AbstractStringAssert, AbstractStringAssert> t){
        assertComposition.add(t);
    }

    public AssertStringBuilder isLessThan(String other) {
        add(a -> a.isLessThan(other));
        return this;
    }

    public AssertStringBuilder isLessThanOrEqualTo(String other) {
        add(a -> a.isLessThanOrEqualTo(other));
        return this;
    }

    public AssertStringBuilder isGreaterThan(String other) {
        add(a -> a.isGreaterThan(other));
        return this;
    }

    public AssertStringBuilder isGreaterThanOrEqualTo(String other) {
        add(a -> a.isGreaterThanOrEqualTo(other));
        return this;
    }

    public AssertStringBuilder isBetween(String start, String end) {
        add(a -> a.isBetween(start, end));
        return this;
    }
    public AssertStringBuilder isStrictlyBetween(String start, String end) {
        add(a -> a.isStrictlyBetween(start, end));
        return this;
    }

    @Override
    protected AbstractStringAssert getCharSequenceApply() {
        return assertComposition.stream()
                // This is a lazy evaluation
                .reduce(a -> a, (a, b) -> a.andThen(b))
                // Call it with apply
                .apply(identity);
    }
}
