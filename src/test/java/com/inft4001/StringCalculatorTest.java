package com.inft4001;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    @Test(expected = RuntimeException.class)
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        StringCalculator.add("1,2,3");
    } // END whenMoreThan2NumbersAreUsedThenExceptionIsThrown

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    } // END when2NumbersAreUsedThenNoExceptionIsThrown

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }

} // END class StringCalculatorTest
