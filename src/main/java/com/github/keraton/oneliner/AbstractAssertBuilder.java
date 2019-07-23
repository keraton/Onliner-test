package com.github.keraton.oneliner;

import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractAssertBuilder<T extends AbstractAssert, SELF> implements Executable {


    SELF self;

    private List<Function<AbstractAssert, AbstractAssert>> assertCompositionObject = new ArrayList<>();


    private void add(Function<AbstractAssert, AbstractAssert> t){
        assertCompositionObject.add(t);
    }

    public SELF isEqualTo(Object other) {
        add(a -> a.isEqualTo(other));
        return self;
    }

    public SELF isNotEqual(Object other) {
        add(a -> a.isNotEqualTo(other));
        return self;
    }

    public SELF isNull() {
        add(a -> a.isEqualTo(null));
        return self;
    }

    public SELF isNotNull() {
        add(a -> a.isNotNull());
        return self;
    }

    public SELF isSameAs(Object expected) {
        add(a -> a.isSameAs(expected));
        return self;
    }

    public SELF isNotSameAs(Object expected) {
        add(a -> a.isNotSameAs(expected));
        return self;
    }

    public SELF isIn(Object... values) {
        add(a -> a.isIn(values));
        return self;
    }

    public SELF isNotIn(Object... values) {
        add(a -> a.isNotIn(values));
        return self;
    }

    public SELF isIn(Iterable<?> values) {
        add(a -> a.isIn(values));
        return self;
    }

    public SELF isNotIn(Iterable<?> values) {
        add(a -> a.isNotIn(values));
        return self;
    }

    public SELF isInstanceOf(Class<?> type) {
        add(a -> a.isInstanceOf(type));
        return self;
    }

    public SELF isInstanceOfAny(Class<?>... types) {
        add(a -> a.isInstanceOfAny(types));
        return self;
    }

    public SELF isNotInstanceOf(Class<?> type) {
        add(a -> a.isNotInstanceOf(type));
        return self;
    }

    public SELF isNotInstanceOfAny(Class<?>... types) {
        add(a -> a.isNotInstanceOfAny(types));
        return self;
    }

    public SELF hasSameClassAs(Object other) {
        add(a -> a.hasSameClassAs(other));
        return self;
    }

    public SELF doesNotHaveSameClassAs(Object other) {
        add(a -> a.doesNotHaveSameClassAs(other));
        return self;
    }

    public SELF isNotExactlyInstanceOf(Class<?> type) {
        add(a -> a.isNotInstanceOfAny(type));
        return self;
    }

    public SELF isOfAnyClassIn(Class<?>... types) {
        add(a -> a.isOfAnyClassIn(types));
        return self;
    }

    public SELF isNotOfAnyClassIn(Class<?>... types) {
        add(a -> a.isNotOfAnyClassIn(types));
        return self;
    }


    @Override
    public void execute() {

        assertCompositionObject.stream()
                // This is a lazy evaluation
                .reduce(a -> a, (a, b) -> a.andThen(b))
                // Call it with apply
                .apply(getApply());

    }

    protected abstract T getApply();


    protected void setSelf(SELF self) {
        this.self = self;
    }
}
