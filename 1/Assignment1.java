// Assignment #: 1
//         Name: Divanshu Chauhan
//    StudentID: 1224087311
//      Lecture: MW 1:30PM-2:45PM
//  Description: This class reads an integer from a keyboard and prints it out
//               along with other messages.

import java.util.Scanner; // use the Scanner class located in the "java.util" directory

public class Assignment1 {
    public static void main(String[] args) {
        // declare a variable
        int number;
        // open a new scanner
        Scanner console = new Scanner(System.in);
        // read an integer entered by a user
        number = console.nextInt();
        // display the number with other messages
        System.out.print("This program reads an integer from a keyboard\n"
                + "and prints it out on the display screen.\n"
                + "Make sure that you get the exact same output as the expected one.\n"
                + "The read number is: " + number + "\n");
        // close the scanner
        console.close();
    }
}
