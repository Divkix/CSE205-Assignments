//  Assignment: Assignment 8
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Class for ReviewHotelTypeComparator which manages
//              the operations for comparing HotelType

//package me.divkix;

// This class implements the Comparator<Hotel> interface (java.util package). It must override the following abstract method:
//
//public int compare(Object first, Object second)
//You can pass two Hotel objects as parameters. The method checks a hierarchy of the following attributes:
//1. Hotel type
//2. Price range
//3. Hotel name
//4. Hotel location
//5. Review
//The method returns an integer that denotes which hotel object comes earlier in this hierarchy. If both hotel types are the same, the method should return an integer that denotes which hotel has the lower price range. If the price range is the same, the method should return an integer that denotes which hotel name comes earlier in the alphabet, etc. TODO: Write the whole class.

import java.util.Comparator;

public class ReviewHotelTypeComparator implements Comparator<Hotel> {
    @Override
    public int compare(Hotel firstHotel, Hotel secondHotel) {
        if (firstHotel.getHotelType().getType().equals(secondHotel.getHotelType().getType())){
            if (firstHotel.getPriceRange() == secondHotel.getPriceRange()){
                if (firstHotel.getHotelName().equals(secondHotel.getHotelName())){
                    if (firstHotel.getLocation().equals(secondHotel.getLocation())){
                        return firstHotel.getReview().compareTo(secondHotel.getReview());
                    }
                    return firstHotel.getLocation().compareTo(secondHotel.getLocation());
                }
                return firstHotel.getHotelName().compareTo(secondHotel.getHotelName());
            }
            return firstHotel.getPriceRange() - secondHotel.getPriceRange();
        }
        return firstHotel.getHotelType().getType().compareTo(secondHotel.getHotelType().getType());
    }
}

