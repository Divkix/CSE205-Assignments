//  Assignment: Assignment 8
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Main class for Hotel which manages
//              the operations for hotel

//package me.divkix;

import java.io.Serializable;

// This class also implements the Serializable interface so that its objects can be stored. The relationship between the class HotelType and Hotel is aggregation, i.e. every Hotel object has a HotelType as part of its instance variables (see UML diagram). In addition to HotelType, a Hotel object also has a name, number of stars (reviewer ratings), a review (String), a price range (integer between 1 and 5, represented as dollar signs in the review), and a hotel location (street address).
//
//TODO: Write the whole class: Declare instance variables, add a constructor, implement the getter methods listed in the UML diagram, and override the toString method.
@SuppressWarnings("ReassignedVariable")
public class Hotel implements Serializable {
    private final String hotelName;
    private final int stars;
    private final String review;
    private final int priceRange;
    private final String location;
    private final HotelType hotelType;

    public Hotel(String hotelName, int stars, String review, int priceRange, String location, HotelType hotelType) {
        this.hotelName = hotelName;
        this.stars = stars;
        this.review = review;
        this.priceRange = priceRange;
        this.location = location;
        this.hotelType = hotelType;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getStars() {
        return stars;
    }

    public int getPriceRange() {
        return priceRange;
    }

    public String getLocation() {
        return location;
    }

    public String getReview() {
        return review;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    // TODO: Write the whole class: Declare instance variables, add a constructor, implement the getter methods listed in the UML diagram, and override the toString method.
    //
    //The toString method should return:
    //hotelName + " hotel\n" + [STARSTRING] + "\t\t" + [PRICESTRING] + "\n" +  hotelType.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n";
    // [STARSTRING] and [PRICESTRING] are Strings that represent the number of stars and dollar signs for the review. Here is an example for a review that the toString method returns (for further examples, see output files of test cases):
    public String toString() {
        StringBuilder starString = new StringBuilder();
        for (int i = 0; i < stars; i++) {
            starString.append("*");
        }

        StringBuilder priceString = new StringBuilder();
        for (int i = 0; i < priceRange; i++) {
            priceString.append("$");
        }

        return hotelName + " hotel\n" + starString + "\t\t" + priceString + "\n" + hotelType.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n";
    }
}
