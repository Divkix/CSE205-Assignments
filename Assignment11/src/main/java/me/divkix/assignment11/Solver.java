//  Assignment: Assignment 11
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Main class for Solver which
//              handles most of the program
//              as it being called by the
//              Assignment11 class.

//package me.divkix.assignment11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Solver {

    // ********************** ADD YOUR CODE HERE **********************
    // instance variables
    private Stack<Node> stack;
    private int[][] grid;
    private int height;
    private int width;
    private int increment;
    private ArrayList<Node> visited;

    public Solver() {
        stack = new Stack<Node>();
        visited = new ArrayList<Node>();
    }

    // Implement isVisited() method to check if a given node has already been visited or not (if the node is in "visited" ArrayList then it is visited)
    public boolean isVisited(Node node) {
        for (Node n : visited) {
            if (n.getX() == node.getX() && n.getY() == node.getY()) {
                return true;
            }
        }
        return false;
    }

    // Implement the depthFirstSearch() method. You are required to use a stack in this method.
    public void depthFirstSearch() {
        // push the first node to the stack
        stack.push(new Node(0, 0));
        // while the stack is not empty
        while (!stack.isEmpty()) {
            // pop the node from the stack
            Node node = stack.pop();
            // if the node is not visited
            if (!isVisited(node)) {
                // add the node to the visited list
                visited.add(node);
                // get the x and y coordinates of the node
                int x = node.getX();
                int y = node.getY();
                // if the node is not the last node
                if (x != height - 1 || y != width - 1) {
                    // if the node is not the last row
                    if (x != height - 1) {
                        // push the node below the current node to the stack
                        stack.push(new Node(x + 1, y));
                    }
                    // if the node is not the last column
                    if (y != width - 1) {
                        // push the node to the right of the current node to the stack
                        stack.push(new Node(x, y + 1));
                    }
                }
                // increment the value of the node
                grid[x][y] += increment;
            }
        }
    }


    // ************************************************************************************
    // ************** Utility method to read grid from user input *************************
    // ************************************************************************************
    public void readGrid() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Height of the grid: ");
            String line = reader.readLine();
            height = Integer.parseInt(line);

            System.out.println("Width of the grid: ");
            line = reader.readLine();
            width = Integer.parseInt(line);
            grid = new int[height][width];

            System.out.println("Increment Factor: ");
            line = reader.readLine();
            increment = Integer.parseInt(line);

            System.out.println("Now enter the grid row by row:");

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    line = reader.readLine();
                    grid[i][j] = Integer.parseInt(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // ************************************************************************************
    // ************** Utility method to print grid ****************************************
    // ************************************************************************************
    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                System.out.print(grid[i][j]);
                System.out.print('	');
            }
            System.out.println();
        }

        System.out.println();
    }

}
