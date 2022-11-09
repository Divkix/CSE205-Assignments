//  Assignment: Assignment 10
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Main class for Assignment 10 which
//              handles the whole program and calls
//              the methods.

package me.divkix;
public class LinkedList {
    Flight first;
    int size;

    public LinkedList(){
        this.first = null;
        this.size = 0;
    }

    // Choice A
    public void addFlight(String flightNumber, String destination, int numberOfPassengers){
        Flight newFlight = new Flight(flightNumber, destination, numberOfPassengers);
        if(this.first == null){
            this.first = newFlight;
        }
        else{
            Flight pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = newFlight;
        }
        this.size++;
    }

}
