//  Assignment: Assignment 10
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Main class for LinkedList which
//              handles the whole program and calls
//              the methods.

//package me.divkix;

public class LinkedList {
    Flight first;
    int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    // The addFlight() method adds a Flight object (flight number, destination, and number of passengers)
    // to the end of the flight list (end of the LinkedList). This method is already provided in the template.
    public void addFlight(String flightNumber, String destination, int numberOfPassengers) {
        Flight newFlight = new Flight(flightNumber, destination, numberOfPassengers);
        if (this.first == null) {
            this.first = newFlight;
        } else {
            Flight pointer = first;
            while (pointer.next != null)
                pointer = pointer.next;

            pointer.next = newFlight;
        }
        this.size++;
    }

    // The getNumberOfPassengers() method checks how many passengers in total are going to a specified destination.
    public int getNumberOfPassengers(String destination) {
        int total = 0;
        Flight pointer = first;
        while (pointer != null) {
            if (pointer.destination.equals(destination))
                total += pointer.numberOfPassengers;
            pointer = pointer.next;
        }
        return total;
    }

    // The removeFirstFlight() method pops the first flight on the flight list (flight is ready to be departed)
    // so that the next flight in the line becomes first on the list. Return the updated Flight object.
    // Make sure to handle the case where the flight list is empty.
    public Flight removeFirstFlight() {
        if (this.first == null)
            return new EmptyFlight();
        Flight temp = this.first;
        this.first = this.first.next;
        this.size--;
        return temp;
    }

    // The listFlights() method will create and return a String containing the information from every flight
    // as well as the total number of flights. If no flights exist, you should return a string stating so.
    // The format of the string returned should be:
    // for the case that no flights are found:
    // "No flights scheduled for departure at this time.\n"
    // if there are flights:
    // [list all reservations using toString]\n
    // "\nTotal flights: " + count + ".\n"
    public String listFlights() {
        if (this.first == null) {
            return "No flights scheduled for departure at this time.\n";
        }
        StringBuilder result = new StringBuilder();
        Flight pointer = this.first;
        while (pointer != null) {
            result.append(pointer);
            pointer = pointer.next;
        }
        result.append("\nTotal flights: ").append(this.size).append(".\n");
        return result.toString();
    }

    // The getPosition() method finds and returns the position of a flight on the flight list based on the
    // flight number. If the flight number is not on the flight list or the flight list is empty, the method
    // should return -1.
    public int getPosition(String flightNumber) {
        if (this.first == null) {
            return -1;
        }
        int position = 1;
        Flight pointer = this.first;
        while (pointer != null) {
            if (pointer.flightNumber.equals(flightNumber))
                return position - 1;
            pointer = pointer.next;
            position++;
        }
        return -1;
    }

    // The removeFlight() method removes a flight from the flight list given the flight's flight number.
    // Return the updated Flight object. Make sure to handle the case where the flight list is empty.
    public Flight removeFlight(String flightNumber) {
        if (this.first == null) {
            return new EmptyFlight();
        }
        Flight pointer = this.first;
        if (pointer.flightNumber.equals(flightNumber)) {
            this.first = this.first.next;
            this.size--;
            return pointer;
        }
        while (pointer.next != null) {
            if (pointer.next.flightNumber.equals(flightNumber)) {
                Flight temp = pointer.next;
                pointer.next = pointer.next.next;
                this.size--;
                return temp;
            }
            pointer = pointer.next;
        }
        return new EmptyFlight();
    }

    // The removeLastFlight() method removes the flight at the end of the flight list.
    // Return the updated Flight object. Make sure to handle the case where the flight list is empty.
    public Flight removeLastFlight() {
        if (this.first == null) {
            return new EmptyFlight();
        }
        Flight pointer = this.first;
        if (pointer.next == null) {
            this.first = null;
            this.size--;
            return pointer;
        }
        while (pointer.next.next != null)
            pointer = pointer.next;
        Flight temp = pointer.next;
        pointer.next = null;
        this.size--;
        return temp;
    }

    // The removeMiddleFlight() method removes a flight in the middle of the list given the flight number.
    // Return the updated Flight object. Make sure to handle the case where the flight list is empty.
    public Flight removeMiddleFlight(String flightNumber) {
        if (this.first == null) {
            return new EmptyFlight();
        }
        Flight pointer = this.first;
        if (pointer.flightNumber.equals(flightNumber)) {
            this.first = this.first.next;
            this.size--;
            return pointer;
        }
        while (pointer.next != null) {
            if (pointer.next.flightNumber.equals(flightNumber)) {
                Flight temp = pointer.next;
                pointer.next = pointer.next.next;
                this.size--;
                return temp;
            }
            pointer = pointer.next;
        }
        return new EmptyFlight();
    }

}
