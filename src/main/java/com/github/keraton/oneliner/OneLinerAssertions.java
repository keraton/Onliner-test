package com.github.keraton.oneliner;

public class OneLinerAssertions {

    public static AssertObjectBuilder assertThat(Object object) {
        return new AssertObjectBuilder(object);
    }

    public static AssertBooleanBuilder assertThat(Boolean b) {
        return new AssertBooleanBuilder(b);
    }

    public static AssertIntegerBuilder assertThat(Integer i) {
        return new AssertIntegerBuilder(i);
    }

    public static AssertStringBuilder assertThat(String s) {
        return new AssertStringBuilder(s);
    }


    // TODO Add Float, Map, List, Set, Double, Long, Short, byte

}
