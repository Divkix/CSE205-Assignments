//  Assignment: Assignment 8
//        Name: Divanshu Chauhan
//   StudentID: 1224807311
//     Lecture: MW 1:30-2:45PM
// Description: Class for ReviewManager which manages
//              the reviews for the hotels.

//package me.divkix;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("ReassignedVariable")
public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;
    ArrayList<Hotel> reviewList;

    public ReviewManager() {
        reviewList = new ArrayList<>();
    }

    public int hotelExists(String hotelName, String location) {
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getHotelName().equals(hotelName) && reviewList.get(i).getLocation().equals(location)) {
                return i;
            }
        }
        return -1;
    }

    // This method returns an ArrayList of integers. Search for a hotel type in the reviewList that has the provided hotelType. Return the indexes of the hotel type if found. If the arrayList is empty then the hotel type doesn't exist.
    public ArrayList<Integer> hotelTypeExists(String hotelType) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getHotelType().getType().equals(hotelType)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    // Getter method
    public Hotel getHotel(int index) {
        return reviewList.get(index);
    }


    /**
     * Add a Hotel object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two hotels are
     * considered duplicated if they have exactly the same hotel name and
     * hotel type.
     *
     * @param hotelName  the name of the hotel
     * @param stars      the number of stars for the hotel
     * @param review     the hotel review
     * @param priceRange the integer price range
     * @param type       the hotel's type
     * @param location   the hotel location (street address)
     * @param topFeature most famous feature of the hotel
     * @return true if the operation is successful; false otherwise
     */
    public boolean addReview(String hotelName, int stars, String review, String priceRange, String type, String location, String topFeature) {
        if (hotelExists(hotelName, location) == -1) {
            int price = priceRange.length();
            HotelType newType = new HotelType(type, topFeature);
            Hotel newHotel = new Hotel(hotelName, stars, review, price, location, newType);
            reviewList.add(newHotel);
            return true;
        }
        return false;
    }

    // Remove a Hotel object with the given hotel name and location
    public boolean removeReview(String hotelName, String location) {
        int index = hotelExists(hotelName, location);
        if (index != -1) {
            reviewList.remove(index);
            return true;
        }
        return false;
    }

    // Sort the reviewList by rating then hotel name in alphabetical order. The method calls the sort method in the Sorts class by using an object generated from the ReviewRatingComparator class
    public void sortByRating() {
        Sorts.sort(reviewList, new ReviewRatingComparator());
    }

    // Sort the reviewList by hotel's type in the alphabetical order of the type of the hotel, then the hotel name. The method calls the sort method defined in the Sorts class by using an object generated from the ReviewHotelTypeComparator class.
    public void sortByHotelType() {
        Sorts.sort(reviewList, new ReviewHotelTypeComparator());
    }

    // List all Hotel objects in reviewList.
    public String listReviews() {
        StringBuilder result = new StringBuilder();
        for (Hotel hotel : reviewList) {
            result.append(hotel.toString());
        }
        return result.toString();
    }

    // Close the Hotel management system by clearing the reviewList.
    public void closeReviewManager() {
        reviewList.clear();
    }
}
