package com.github.keraton.oneliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import org.junit.jupiter.engine.execution.BeforeEachMethodAdapter;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneLinerExtension implements BeforeEachMethodAdapter, AfterEachMethodAdapter {


    private static ThreadLocal<List<DynamicNode>> threadLocal = new ThreadLocal<>();


    // BDD Style
    public static DynamicContainer when(String displayName, DynamicTest... tests) {
        return DynamicContainer.dynamicContainer("When " + displayName, Arrays.asList(tests));
    }

    public static DynamicTest then(String displayName, Executable executable) {
        return DynamicTest.dynamicTest("Then " + displayName, executable);
    }

    public static void given(String displayName, DynamicNode... tests) {
        getDynamicNode().add(DynamicContainer.dynamicContainer("Given " + displayName, Arrays.asList(tests)));
    }

    // RSpec Style
    public static DynamicContainer context(String displayName, DynamicTest... tests) {
        return DynamicContainer.dynamicContainer("Context : " + displayName, Arrays.asList(tests));
    }
    public static DynamicTest it(String displayName, Executable executable) {
        return DynamicTest.dynamicTest("it " + displayName, executable);
    }


    public static void describe(String displayName, DynamicNode... tests) {
        getDynamicNode().add(DynamicContainer.dynamicContainer("Describe " + displayName, Arrays.asList(tests)));
    }

    // Should style
    public static void should(String displayName, Executable executable) {
        getDynamicNode().add(DynamicTest.dynamicTest("Should " + displayName, executable));
    }
    // Test style

    public static void test(String displayName, Executable executable) {
        getDynamicNode().add(DynamicTest.dynamicTest(displayName, executable::execute));
    }

    public static void testFail(String displayName, Executable executable) {
        Executable executableMustFailed = () -> {
            boolean notFailed = false;
            try {
                executable.execute();
                notFailed = true;
            }
            catch (AssertionError error) {

            }
            if (notFailed) {
                Assertions.fail("Should Failed");
            }

        };
        getDynamicNode().add(DynamicTest.dynamicTest(displayName, executableMustFailed::execute));
    }


    public static List<DynamicNode> nodes() {
        List<DynamicNode> nodes = new ArrayList<>(getDynamicNode());
        getDynamicNode().clear();
        return nodes;
    }

    @Override
    public void invokeAfterEachMethod(ExtensionContext context, ExtensionRegistry registry) {
        threadLocal.remove();
    }

    @Override
    public void invokeBeforeEachMethod(ExtensionContext context, ExtensionRegistry registry) {
        threadLocal.set(new ArrayList<>());
    }

    private static List<DynamicNode> getDynamicNode() {
        return threadLocal.get();
    }


}




