package com.inft4001;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class StringCalculatorTest {
//    @Test(expected = RuntimeException.class)
//    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//        StringCalculator.add("1,2,3");
//    } // END whenMoreThan2NumbersAreUsedThenExceptionIsThrown

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    } // END when2NumbersAreUsedThenNoExceptionIsThrown

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        Assert.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        Assert.assertEquals(3, StringCalculator.add("3"));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        Assert.assertEquals(3+6, StringCalculator.add("3,6"));
    }

    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15+18+46+33, StringCalculator.add("3,6,15,18,46,33"));
    }

    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15, StringCalculator.add("3,6n15"));
    }

    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(3+6+15, StringCalculator.add("//;n3;6;15"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        StringCalculator.add("3,-6,15,18,46,33");
    }

    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        RuntimeException exception = null;
        try {
            StringCalculator.add("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }

    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
        Assert.assertEquals(3+1000+6, StringCalculator.add("3,1000,1001,6,1234"));
    }

    @Test
    public final void whenDelimiterIsSpecifiedOfAnyLengthThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(2+4+8, StringCalculator.add("//---n---2-4----8"));
    }

    @Test
    public final void whenMultipleDelimitersAreSpecifiedThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(2+4+9+11+15, StringCalculator.add("//-%n-2%4-9%11-15"));
    }

    @Test
    public final void whenMultipleDelimitersAreSpecifiedOfAnyLengthThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(2+4+8+11, StringCalculator.add("//--%%n---2%4--8%%11"));
    }
} // END class StringCalculatorTest
