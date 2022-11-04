//  Assignment: Assignment 9
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Main class for Assignment 9 which
//              handles the whole program and calls
//              the methods.

// package me.divkix.assignment9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Assignment9 {

    public static void main(String[] args) {
        // declare variables
        int inputOpt;
        int[] intList;
        String inputText;
        // start the try catch block
        try {
            // ask for user inputs, use InputStreamReader
            // and BufferedReader to process input.
            // Use a while loop to keep asking for input
            // until the user enters 5 to exit the program.
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);
            do {
                // print the menu
                printMenu();
                // for taking a number as an input
                inputOpt = Integer.parseInt(stdin.readLine());
                // switch case on the input
                switch (inputOpt) {
                    case 1:
                        // start choice 1
                        // use the utility method parseInts() to read integers from standard input
                        intList = parseInts(stdin);
                        // check for the largest prime number in the list using a loop
                        int largestPrimeNumber = 0;
                        // use the utility method isPrime() to check if a number is prime
                        // if the number is prime, check if it is larger than the largest prime number
                        // if it is, set it as the largest prime number
                        for (int j: intList) {
                            if (isPrime(j) && j > largestPrimeNumber) {
                                largestPrimeNumber = j;
                            }
                        }
                        // print the output
                        System.out.println("The largest prime number in the array is: " + largestPrimeNumber);
                        break;
                    case 2:
                        // start choice 2
                        // use the utility method parseInts() to read integers from standard input
                        intList = parseInts(stdin);
                        // print the output
                        System.out.println(("The sum of all even numbers in the array is: " + sumEven(intList)));
                        break;
                    case 3:
                        // start choice 3
                        // ask user to enter the string
                        System.out.println("Please enter String:");
                        // read the string from standard input
                        inputText = stdin.readLine();
                        // print the output
                        System.out.println("Palindrome test result is: " + isPalindrome(inputText));
                        break;
                    case 4:
                        // start choice 4
                        // ask user to enter the string
                        System.out.println("Please enter String:");
                        // read the string from standard input
                        inputText = stdin.readLine();
                        // print the output
                        System.out.println("String after removing all occurrences of character \"A\": " + removeAFromString(inputText, -1));
                        break;
                    case 5:
                        // start choice 5
                        // exit the program
                        break;
                    default:
                        // if the user enters an invalid input, print an error message
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                        break;
                }
            } while (inputOpt == 1 || inputOpt == 2 || inputOpt == 3 || inputOpt == 4);
            // if the user enters any number other than 1, 2, 3 or 4; exit the program
        } catch (IOException exception) {
            // handle the exception
            System.out.print("IO Exception: \n");
        }


    }

    // utility method to check if a number is prime
    public static boolean isPrime(int n) {
        // if n is less than 2, it is not prime, return false
        if (n <= 1) {
            return false;
        }

        // Check from 2 to n-1 using a for loop,
        // if any number divides n, return false
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        // if no number divides n, return true
        return true;
    }

    // utility method to give sum of all even numbers in an ArrayList
    public static int sumEven(int[] arr)  {
        // initiate a variable to make sure at least one even number is present
        boolean anyEven = false;

        // if length of the arraylist is 0, return -1
        if (arr.length == 0) {
            return 0;
        }

        // iterate over the array and make sure all numbers are even,
        // if not, return 0
        for (int j: arr) {
            if (j % 2 == 0) {
                anyEven = true;
            }
        }

        // if 'anyeven' is false, return 0
        if (!anyEven) {
            return 0;
        }

        // check if number is even, else remove it from the arraylist and call the method again
        if (arr[0] % 2 == 0) {
            return arr[0] + sumEven(Arrays.copyOfRange(arr, 1, arr.length));
        }

        // if the number is even, add it to the sum and remove it from the arraylist
        // then call the method again
        return sumEven(Arrays.copyOfRange(arr, 1, arr.length));
    }

    // utility method to check if a string is a palindrome or not
    public static boolean isPalindrome(String palString) {
        // if length of the string is 0 or 1, return true
        // length of 0 means the string is empty
        // length of 1 means the string has only one character
        if (palString.length() == 0 || palString.length() == 1) {
            return true;
        }

        // check if the first and last characters are the same
        // then call the method again with the substring of the string,
        // excluding the first and last characters
        if (palString.charAt(0) == palString.charAt(palString.length() - 1)) {
            // substring method is used to get the substring of the string
            // we are removing the first and last characters from the string
            // and calling the method again
            return isPalindrome(palString.substring(1, palString.length() - 1));
        }

        // by default, return false
        return false;
    }

    // utility method to remove 'A' from the string
    public static String removeAFromString(String myString, int charIndex) {
        // we are using -1 to check if the method is called for the first time
        if (charIndex != -1) {
            // the charIndex is the index of the character 'A'
            // remove the character at the given index from the string
            // using the substring method
            myString = myString.substring(0, charIndex) + myString.substring(charIndex + 1);
        }
        // iterate over all the characters in the string to check if there is an 'A' in the string
        for (int i = 0; i < myString.length(); i++) {
            // if there is an 'A', call the method again with the index of the character 'A'
            if (myString.charAt(i) == 'A') {
                // if any character in string is 'A', recursively call the method
                return removeAFromString(myString, i);
            }
        }
        // myString should be returned if there are no 'a' characters in the string
        return myString;
    }

    // Utility method for printing the menu
    public static void printMenu() {
        System.out.print("\nWhat would you like to do?\n\n");
        System.out.print("1: Find the largest prime number in an array of integers\n");
        System.out.print("2: Calculate the sum of all even numbers in an array of integers\n");
        System.out.print("3: Check if a string is palindrome or not\n");
        System.out.print("4: Remove all occurrences of character \"A\" in a String\n");
        System.out.print("5: Quit\n\n");
    }

    // utility method for parsing integers from standard input
    public static int[] parseInts(BufferedReader reader) {
        String line = "";
        ArrayList<Integer> container = new ArrayList<>();
        try {
            System.out.print("Please enter integers:\n");
            line = reader.readLine();
            int num = Integer.parseInt(line);

            while (num > 0) {
                container.add(num);
                line = reader.readLine();
                num = Integer.parseInt(line);
            }

        } catch (IOException ex) {
            System.out.println("IO Exception");
        }

        int[] result = new int[container.size()];
        for (int i = 0; i < container.size(); i++) {
            result[i] = container.get(i);
        }
        return result;
    }

}
