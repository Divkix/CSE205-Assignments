//  Assignment: Assignment 10
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Main class for Flight which
//              is used by program.

//package me.divkix;

public class Flight {
    String flightNumber;
    String destination;
    int numberOfPassengers;
    Flight next;

    public Flight(String flightNumber, String destination, int numberOfPassengers) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.next = null;
    }

    public String toString() {
        return "\nFlight Number " + this.flightNumber + " going to " + this.destination + " has " + this.numberOfPassengers + " passengers" + ".\n";
    }

}
