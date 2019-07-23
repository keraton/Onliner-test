package com.github.keraton.oneliner;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class OneLinerBuilder  {


    private List<DynamicNode> dynamicNodes;

    private List<DynamicNode> getDynamicNode() {
        return this.dynamicNodes;
    }

    private OneLinerBuilder() {
        this.dynamicNodes = new ArrayList<>();
    }

    public static OneLinerBuilder oneLinerBuilder() {
        return new OneLinerBuilder();
    }

    // BDD Style
    public OneLinerBuilder given(String displayName, DynamicNode... tests) {
        getDynamicNode().add(DynamicContainer.dynamicContainer("Given " + displayName, Arrays.asList(tests)));
        return this;
    }

    // RSpec Style
    public OneLinerBuilder describe(String displayName, DynamicNode... tests) {
        getDynamicNode().add(DynamicContainer.dynamicContainer("Describe " + displayName, Arrays.asList(tests)));
        return this;
    }

    // Should style
    public OneLinerBuilder should(String displayName, Executable executable) {
        getDynamicNode().add(DynamicTest.dynamicTest("Should " + displayName, executable));
        return this;
    }

    // Test style
    public OneLinerBuilder test(String displayName, Executable executable) {
        getDynamicNode().add(DynamicTest.dynamicTest(displayName, executable::execute));
        return this;
    }

    public List<DynamicNode> build() {
        return dynamicNodes;
    }



}




