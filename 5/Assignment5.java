/*
 Assignment #: 5
         Name: Divanshu Chauhan
    StudentID: 1224087311
      Lecture: MW 1:30PM-2:45PM
  Description: Assignment 5 class displays a menu of choices to a user
               and performs the chosen task. It will keep asking a user to
               enter the next choice until the choice of 'Q' (Quit) is entered.
*/

import java.io.*;         // to use InputStreamReader and BufferedReader
import java.util.*;       // to use ArrayList

public class Assignment5 {
    public static void main(String[] args) {
        // initialize variables
        char input;
        String line;
        String inputInfo;

        // ArrayList used to store the aircraft objects
        ArrayList<AircraftEntity> aircraftList = new ArrayList<>();
        try {
            System.out.println("Welcome to the aircraft stats simulator!");
            printMenu();

            // create a BufferedREader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);
            do {
                System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);
                if (line.length() == 1) {
                    switch (input){
                        case 'A': // add aircraft to the fleet
                            System.out.println("Please enter your aircraft stats:\n");
                            inputInfo = stdin.readLine().trim();
                            AircraftEntity newAircraft = AircraftParser.parseNewAircraft(inputInfo);
                            aircraftList.add(newAircraft);
                            break;
                        case 'C': // calculate attack powers
                            for (AircraftEntity aircraft : aircraftList) {
                                aircraft.computeAttackPower();
                            }
                            System.out.println("Attack powers computed");
                            break;
                        case 'D': // how many aircrafts have attack power equal to or larger than a user-defined value
                            System.out.print("Please enter a minimum attack power you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;

                            // loop through the aircraft list and count the number of aircrafts with attack power equal to or larger than the user-defined value
                            for (AircraftEntity aircraft : aircraftList) {
                                if (aircraft.getAttackPower() >= min) {
                                    count++;
                                }
                            }

                            System.out.println("The number of aircrafts with " + min + " attack powers or more is: " + count);
                            break;
                        case 'L': // list aircrafts
                            if (aircraftList.size() == 0) {
                                System.out.println("No aircrafts in the fleet yet.");
                            } else {
                                for (AircraftEntity aircraft : aircraftList) {
                                    System.out.println(aircraft.toString());
                                }
                            }
                            break;
                        case 'Q':
                            break;
                        case '?':
                            printMenu();
                            break;
                        default:
                            System.out.println("Unknown action\n");
                            break;
                    }
                }
                else
                    System.out.println("Unknown action");
            } while (input != 'Q');
        }
        catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
    public static void printMenu(){
        System.out.print(
                "Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Aircraft\n" +
                "C\t\tCompute Attack Power\n" +
                "D\t\tCalculate the Number of Aircrafts with Minimum Attack Power\n" +
                "L\t\tList Aircrafts\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n"
        );
    }
}
