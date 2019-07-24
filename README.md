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

I did this a lot when I exercising with TDD Kata.

## How to

TODO