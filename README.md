# Onliner Test

## TL;DR

### Code

For the impatient, this lib let you to write test like this.
```
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
```

And you will have for each line a valid self description test.

![Example](/doc/images/oneliner-result.png)

### Why ?

No ceremony !!

## Motivation
A good test should test one and only one use case at one time.
The test should have a _Given_ context, _When_ action and _Then_ for the assertion.
But there are cases that those three stages are very obvious and can be resumed to one line test.
Do we need to write them to multiple lines ?
Take examples :

```
@Test
void should_do_addition() {
    // Given
    var a = 1;
    var b = 1;
    
    // When 
    var result = add(a, b);
    
    // Then
    assertThat(result).isEqualTo(2);
  
}

```

While it is nice to have this kind of test, it would be a waste of time (and spaces), especially when we got a lot these tests.
 
```
@Test
void should_do_case1() {
    ...
}

@Test
void should_do_case2() {
    ...
}

@Test
void should_do_case3() {
    ...
}

...

```
Or what you want is to write something like this.
```
@Test
void should_test_whole_cases() {
    assertThat(result_case1).isEqualTo(doCases(input_case1));   
    assertThat(result_case2).isEqualTo(doCases(input_case2));   
    assertThat(result_case3).isEqualTo(doCases(input_case3));
    ...   
}

```
But this would violate the one test one assert.
And what happen when case 1 is failed, the test will stop without verifying other cases.
Worst we cannot show our intent for each case, in the Junit Reporter only one case (here, the method name) that will be showed.
For this need we create *oneliner test* that let you do one line test without having those inconvenient.

### Lovely Use case ♥

I use this a lot when I exercising with TDD Kata.

## How to

### Install

For the time being, you need to download/clone the code and install it with maven.
```
mvn clean install
```
This will deploy the artifact into your repository.
I plan to deploy to Maven central repository when the code completion is ready.

### Dependencies

We are using Junit 5 as the backbone for this test and AssertJ as the assertion tools.
Using AssertJ is not mandatory, but we have done a lot of effort to make fluent API with AssertJ.

Under the hood, what we are creating are the DynamicTest. 
This feature has been around since the Junit 5 arrives.
Basically we are just make the use of dynamicTest to be easier and more fluent.

TODO : provide a list of supported version of Junit 5 and AssertJ.

### Using in a test

There are two ways to use this library.
- Using Junit 5 Extension
- Using Builder

### Extension

To use with a Junit Extension, you need to add OneLinerExtension in the Extension annotation.
Then you need create the test factory method.
This method should return a Collection of DynamicNode and annotated with @TestFactory.

Inside the method you can use the Oneliner test builder such as : should, test, given/when/then and describe/it.
At the end of the method you can use nodes() method that will return the tests.

```

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
    List<DynamicNode> test_assertBoolean() {

        test("isTrue", assertThat(true).isTrue());
        test("isFalse", assertThat(false).isFalse());
        test("isEqualTo", assertThat(true).isEqualTo(true));
        test("isFalse", assertThat(false).isNotEqualTo(true));

        test("isFalse", assertThat(Boolean.FALSE).isNotEqualTo(true));
        test("isTrue", assertThat(Boolean.TRUE).isEqualTo(true));

        return nodes();
    }

  

}

```

### Builder

Using Builder is more straightforward, you still need to write the factory method.
But now you can use a OneLinerBuilder to build the test.

```
package com.github.keraton.oneliner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static com.github.keraton.oneliner.OneLinerBuilder.oneLinerBuilder;
import static com.github.keraton.oneliner.OneLinerExtension.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("One line Test")
class OneLinerBuilderTest {


    @TestFactory
    List<DynamicNode> buildBDDTest() {

        // Lambda mode
        // BDD Style
        return oneLinerBuilder().
                given("one line test",
                        when("run",
                                then("do equal ", () -> assertThat(1).isEqualTo(1)),
                                then("2nd dynamic test", () -> assertThat(1).isEqualTo(1))),

                        when("run again",
                                then("do equal ", () -> assertThat(1).isEqualTo(1)),
                                then("2nd dynamic test", () -> assertThat(1).isEqualTo(1)))
                ).
                given("one line test without when",
                        then("do equal ", () -> assertThat(1).isEqualTo(1)),
                        then("2nd dynamic test", () -> assertThat(1).isEqualTo(1))
                ).
                build();
    }

    @TestFactory
    List<DynamicNode> buildRSpecTest() {

        // Lambda mode
        // BDD Style
        return oneLinerBuilder().
                describe("one line test",
                        context("I would like to test with fun",
                                it
                                        ("do equal ", () -> assertThat(1).isEqualTo(1)),
                                it("2nd dynamic test", () -> assertThat(1).isEqualTo(1))),

                        context("This is so much fun",
                                it("do equal ", () -> assertThat(1).isEqualTo(1)),
                                it("2nd dynamic test", () -> assertThat(1).isEqualTo(1)))
                ).
                build();
    }
    @TestFactory
    List<DynamicNode> buildTest() {

        // Lambda mode
        // BDD Style
        return oneLinerBuilder().
                should("1 = 1", () -> assertThat(1).isEqualTo(1)).
                should("2 = 2", () -> assertThat(2).isEqualTo(2)).
                test("1 = 1", () -> assertThat(1).isBetween(0, 2)).
                build();
    }
}


```

### Test Style

Currently we are supporting three different styles.
- test/should : direct one line test.
- BDD  : create a Given / When / Then style.
- Rspec : create a Describe / Context / It.

Both BDD and Rspec let you to write a nested test.

### Assertions

You can use lambda executable method. 
Using lambda let you to have a more flexible way to write your test.
And you don't have to use assertJ as your assertion library.
However, in Java you will have to write the lambda ceremony `() ->`.
Kotlin have better syntax dealing with lambda.
Instead of having `() ->` we can use `test("some description"") { assertThat() ..}`

We are providing a large assertion builder.
This is provided by OneLinerAssertions class.
With OneLinerAssertions we omit the `() ->`. 
The inconvenient of OneLinerAssertions is that they are not complete as normal AssertJ assertions (But we are working on it).

### Contributing

You are welcome to contribute, we need to add as much as possible assertions adaptation.
You can create a pull request and we will review and merge them.   
