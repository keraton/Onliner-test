package com.github.keraton.oneliner;

import org.assertj.core.api.AbstractCharSequenceAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractAssertCharSequenceBuilder<T extends AbstractCharSequenceAssert, SELF extends AbstractAssertCharSequenceBuilder>
        extends AbstractAssertBuilder<AbstractCharSequenceAssert, SELF> {

    private List<Function<AbstractCharSequenceAssert, AbstractCharSequenceAssert>> assertComposition = new ArrayList<>();

    private void add(Function<AbstractCharSequenceAssert, AbstractCharSequenceAssert> t){
        assertComposition.add(t);
    }

    public SELF isEmpty() {
        add(a ->  {a.isEmpty(); return a;});
        return self;
    }

    public SELF isNullOrEmpty() {
        add(a -> {a.isNullOrEmpty();; return a;});
        return self;
    }

    public SELF isNotEmpty() {
        add(a -> a.isNotEmpty());
        return self;
    }

    public SELF isBlank() {
        add(a -> a.isBlank());
        return self;
    }

    public SELF contains(CharSequence... values) {
        add(a -> a.contains(values));
        return self;
    }

    public SELF containsSequence(CharSequence... values) {
        add(a -> a.containsSequence(values));
        return self;
    }

    public SELF containsIgnoringCase(CharSequence value) {
        add(a -> a.containsIgnoringCase(value));
        return self;
    }

    public SELF doesNotContain(CharSequence... values) {
        add(a -> a.doesNotContain(values));
        return self;
    }

    public SELF doesNotContainPattern(CharSequence pattern) {
        add(a -> a.doesNotContainPattern(pattern));
        return self;
    }

    public SELF doesNotContainPattern(Pattern pattern) {
        add(a -> a.doesNotContainPattern(pattern));
        return self;
    }

    public SELF startWith(CharSequence prefix) {
        add(a -> a.startsWith(prefix));
        return self;
    }

    public SELF doesNotStartWtih(CharSequence prefix) {
        add(a -> a.doesNotStartWith(prefix));
        return self;
    }

    public SELF endWith(CharSequence suffix) {
        add(a -> a.endsWith(suffix));
        return self;
    }

    public SELF doestNotEndWith(CharSequence suffix) {
        add(a -> a.doesNotEndWith(suffix));
        return self;
    }

    public SELF matches(CharSequence regex) {
        add(a -> a.matches(regex));
        return self;
    }

    public SELF doesNotMatches(CharSequence regex) {
        add(a -> a.doesNotMatch(regex));
        return self;
    }

    public SELF matches(Pattern regex) {
        add(a -> a.matches(regex));
        return self;
    }

    public SELF doesNotMatches(Pattern regex) {
        add(a -> a.doesNotMatch(regex));
        return self;
    }

    public SELF isEqualToIgnoringWhitespace(CharSequence expected) {
        add(a -> a.isEqualToIgnoringWhitespace(expected));
        return self;
    }

    public SELF isNotEqualToIgnoringWhitespace(CharSequence expected) {
        add(a -> a.isNotEqualToIgnoringWhitespace(expected));
        return self;
    }

    public SELF isSubstringOf(CharSequence sequence){
        add(a -> a.isSubstringOf(sequence));
        return self;
    }

    public SELF containsPattern(CharSequence regex) {
        add(a -> a.containsPattern(regex));
        return self;
    }

    public SELF containsPattern(Pattern regex) {
        add(a -> a.containsPattern(regex));
        return self;
    }

    public SELF isLowerCase() {
        add(a -> a.isLowerCase());
        return self;
    }

    public SELF isUpperCase() {
        add(a -> a.isUpperCase());
        return self;
    }

    public SELF containsOnlyDigit() {
        add(a -> a.containsOnlyDigits());
        return self;
    }

    @Override
    protected final AbstractCharSequenceAssert getApply() {
        return assertComposition.stream()
                // This is a lazy evaluation
                .reduce(a -> a, (a, b) -> a.andThen(b))
                // Call it with apply
                .apply(getCharSequenceApply());
    }

    protected abstract T getCharSequenceApply();
}
