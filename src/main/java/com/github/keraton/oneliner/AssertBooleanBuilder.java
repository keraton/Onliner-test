package com.github.keraton.oneliner;

import org.assertj.core.api.AbstractBooleanAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertBooleanBuilder extends AbstractAssertBuilder<AbstractBooleanAssert, AssertBooleanBuilder> {

    private List<Function<AbstractBooleanAssert, AbstractBooleanAssert>> assertComposition = new ArrayList<>();
    private AbstractBooleanAssert identity;

    public AssertBooleanBuilder(Boolean b) {
        identity = assertThat(b);
        setSelf(this);
    }

    private void add(Function<AbstractBooleanAssert, AbstractBooleanAssert> t){
        assertComposition.add(t);
    }

    private AssertBooleanBuilder buildEqualTo(boolean equal) {
        add(anAssert -> anAssert.isEqualTo(equal));
        return this;
    }

    protected AssertBooleanBuilder isTrue() {
        return buildEqualTo(true);
    }

    protected AssertBooleanBuilder isFalse() {
        return buildEqualTo(false);
    }

    protected AssertBooleanBuilder isEqualTo(boolean b) {
        return buildEqualTo(b);
    }

    protected AssertBooleanBuilder isNotEqualTo(boolean b) {
        return buildEqualTo(!b);
    }


    @Override
    public AbstractBooleanAssert getApply() {
        return assertComposition.stream()
                // This is a lazy evaluation
                .reduce(a -> a, (a, b) -> a.andThen(b))
                // Call it with apply
                .apply(identity);
    }
}
