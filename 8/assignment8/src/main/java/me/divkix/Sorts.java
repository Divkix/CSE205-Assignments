//  Assignment: Assignment 8
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Class for Sorts which manages
//              the operations for sorting

//package me.divkix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("ReassignedVariable")
public class Sorts {
    // The Sorts class a utility class that will be used to sort a list of Hotel objects base on different criteria,
    // such as the hotel’s rating and hotel type. Sorting algorithms have been (and will be) covered in class.
    // You can use any sorting algorithms, such as Selection sort, Insertion Sort, MergeSort, or QuickSort, but make
    // sure your sort method is able to sort an ArrayList of objects. The Sorts class will never be instantiated.
    // It should only contain the following static method with the exact method header:
    // public static void sort(ArrayList<Hotel> reviewList, Comparator<Hotel> xComparator)
    public static void sort(ArrayList<Hotel> reviewList, Comparator<Hotel> xComparator) {
        int min;
        for (int i = 0; i < reviewList.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < reviewList.size(); j++) {
                if (xComparator.compare(reviewList.get(j), reviewList.get(min)) < 0) {
                    min = j;
                }
            }
            Collections.swap(reviewList, i, min);
        }
    }
}
