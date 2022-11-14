//  Assignment: Assignment 11
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Main class for Assignment11 which
//              handles the whole program and calls
//              the methods.

//package me.divkix.assignment11;

public class Assignment11 {

    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.readGrid();

        System.out.println("Original grid: ");
        solver.printGrid();

        solver.depthFirstSearch();

        System.out.println("Grid after increment: ");
        solver.printGrid();
    }
}