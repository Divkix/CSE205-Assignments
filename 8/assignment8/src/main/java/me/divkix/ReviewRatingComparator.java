//  Assignment: Assignment 8
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Class for ReviewRatingComparator which manages
//              the operations for comparing Rating.

//package me.divkix;

import java.util.Comparator;


// You can pass two Hotel objects as parameters. The method checks a hierarchy of the following attributes:
//1. Stars
//2. Hotel name
//3. Hotel location
//4. Review
//The method returns the difference in rating (stars of first hotel minus stars of second hotel) if one hot got superior reviews over the other. If both hotels have the same number of stars, the comparison should return an integer that denotes which hotel comes earlier in the alphabet, etc.  TODO: Write the whole class.

public class ReviewRatingComparator implements Comparator<Hotel> {

    @Override
    public int compare(Hotel firstHotel, Hotel secondHotel) {
        if (firstHotel.getStars() == secondHotel.getStars()){
            if (firstHotel.getHotelName().equals(secondHotel.getHotelName())){
                if (firstHotel.getLocation().equals(secondHotel.getLocation())){
                    return firstHotel.getReview().compareTo(secondHotel.getReview());
                }
                return firstHotel.getLocation().compareTo(secondHotel.getLocation());
            }
            return firstHotel.getHotelName().compareTo(secondHotel.getHotelName());
        }
        return firstHotel.getStars() - secondHotel.getStars();
    }
}

