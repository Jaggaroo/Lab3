package com.inft4001;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {


    public static int add(final String numbers) {
        String delimiter = ",|n";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
        }
        return add(numbersWithoutDelimiter, delimiter);
    }

    private static int add(final String numbers, final String delimiter) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        List negativeNumbers = new ArrayList();
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                } else if (numberInt <= 1000) {
                    returnValue += numberInt;
                }
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return returnValue;
    } // END public static void add(String numbers)

//    public static void subtract(String numbers) {
//        String[] numbersArray = numbers.split(",");
//        if (numbersArray.length > 2) {
//            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
//        } else {
//            for (String number : numbersArray) {
//                Integer.parseInt(number); // If it is not a number, parseInt will throw an exception
//            }
//        }
//    } // END public static void subtract(String s)

} // END class StringCalculator
