package com.inft4001;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class StringCalculator {


    public static int add(final String numbers) {
        String delimiter = ",";
        String numbersWithoutDelimiter = numbers;
        String characterHolder = "";
//        System.out.println("numbers: " + numbers);

        StringBuilder SBHolder= new StringBuilder();

        String delimiterString;
        if (numbers.startsWith("//")) {
//            int delimiterIndex = numbers.indexOf("//") + 2;
//            System.out.println("delimiterIndex: " + delimiterIndex);
            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
//            System.out.println("numbersWithoutDelimiter: " + numbersWithoutDelimiter);

            delimiterString = numbers.substring(2,numbers.indexOf("n"));
//            System.out.println("delimiterString: " + delimiterString);

            for (int i = 0; i < delimiterString.length(); i++) {
                if(SBHolder.toString().indexOf(delimiterString.charAt(i)) == -1 ){
                    SBHolder.append(delimiterString.charAt(i));
                }
            }
            delimiterString = SBHolder.toString();
//            System.out.println("2nd delimiterString: " + delimiterString);

            SBHolder.setLength(0);

//            System.out.println(" ");
//            System.out.println("FINISHED FIRST PART: ");
//            System.out.println(" ");

            for (int i = 0; i < numbersWithoutDelimiter.length(); i++)
            {
                characterHolder = String.valueOf(numbersWithoutDelimiter.charAt(i));
//                System.out.println("characterHolder: " + i + " " + characterHolder);
//
//                System.out.println("Mid numbersWithoutDelimiter: " + numbersWithoutDelimiter);

                for(int j = 0; j < delimiterString.length(); j++)
                {

//                    System.out.println("delimiterString.charAt(j) : " + j + " " + delimiterString.charAt(j));

                    if(delimiterString.charAt(j) == numbersWithoutDelimiter.charAt(i))
                    {
//                        System.out.println("MATCH J I Characters: " + j + " " + i + " " + delimiterString.charAt(j) + " " + numbersWithoutDelimiter.charAt(i));
                        characterHolder = delimiter;
                        break;
                    }

//                    System.out.println(" ");
//                    System.out.println("FINISHED JJJJJ LOOP: " + j);
//                    System.out.println(" ");

                }

                SBHolder.append(characterHolder);
//                System.out.println("APPEND SBHolder.toString() J: " + SBHolder.toString());
//
//                System.out.println(" ");
//                System.out.println("FINISHED III LOOP: " + i);
//                System.out.println(" ");

            }
            numbersWithoutDelimiter = SBHolder.toString();

        } // END if (numbers.startsWith("//"))

        return add(numbersWithoutDelimiter, delimiter);
    }


//        String delimiter = ",|--|n";
//    String numbersWithoutDelimiter = numbers;
//        if (numbers.startsWith("//")) {
//        int delimiterIndex = numbers.indexOf("//") + 2;
//        delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
//        numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
//    }
//        return add(numbersWithoutDelimiter, delimiter);
//}

    private static int add(final String numbers, String delimiter) {
        int returnValue = 0;
        delimiter = ",|n";
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
