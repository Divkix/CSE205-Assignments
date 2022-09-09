// Assignment #: 2
//         Name: Divanshu Chauhan
//    StudentID: 1224087311
//      Lecture: MW 1:30PM-2:45PM
//  Description: This class  reads in an unspecified number of integers
//               from standard input, performs some calculations on the
//               inputted numbers, and outputs the results of those
//               calculations to standard output.

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Assignment2 {
    public static void main(String[] args) {
        // set some variables
        int minNum = 0;
        int oddCount = 0;
        int largestEvenNum = 0;
        int positiveNumSum = 0;
        int newNum;

        // initialize a new scanner
        Scanner scnr = new Scanner(System.in);
        // check for next int in standard input
        while (scnr.hasNextInt()) {
            // read the next int
            int inputNum = scnr.nextInt();

            // loop if input is 0, end the loop
            if (inputNum == 0) {
                newNum = inputNum;
                if (newNum < minNum) {
                    minNum = newNum;
                }
                break;
            } else {
                // if inputNum is not zero, run a while loop

                // set newNum as inputNum
                newNum = inputNum;
                // set minNum as newNum is its smaller than current onw
                if (newNum < minNum) {
                    minNum = newNum;
                }

                // if number is not divisible by 2, add 1 to oddCount
                if (newNum % 2 != 0) {
                    oddCount += 1;
                }

                // if newNum is divisible by 2 and newNum is greater than largestEvenNum, set
                // largestEvenNum as newNum
                if ((newNum % 2 == 0) && (newNum > largestEvenNum)) {
                    largestEvenNum = newNum;
                }

                // if newNum is greater than 0, add it to positiveNumSum
                if (newNum > 0) {
                    positiveNumSum += newNum;
                }
            }
        }

        scnr.close();
        System.out.println("The minimum integer is " + minNum);
        System.out.println("The count of odd integers in the sequence is " + oddCount);
        System.out.println("The largest even integer in the sequence is " + largestEvenNum);
        System.out.println("The sum of positive integers is " + positiveNumSum);
    }
}