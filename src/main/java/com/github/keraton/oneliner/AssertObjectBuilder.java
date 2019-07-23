package com.github.keraton.oneliner;

import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertObjectBuilder extends AbstractAssertBuilder<AbstractAssert, AssertObjectBuilder> {

    private AbstractAssert identity;

    public AssertObjectBuilder(Object o) {
        identity = assertThat(o);
        setSelf(this);
    }


    @Override
    protected AbstractAssert getApply() {
        return identity;
    }
}
