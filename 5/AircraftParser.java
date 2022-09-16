/*
 Assignment #: 5
         Name: Divanshu Chauhan
    StudentID: 1224087311
      Lecture: MW 1:30PM-2:45PM
  Description: AircraftParser class helps parse the aircraft data from the user input and return the aircraft object
*/

public class AircraftParser {
    // static method to parse the data provided by user and create an AircraftParser object
    public static AircraftEntity parseNewAircraft(String lineToParse) {
        // initialize variables
        double minFlyingAltitude = 0;
        double maxSpeed = 0;
        String bomberType = "";
        boolean isJet = false;

        // split the string into an array
        String[] lineArray = lineToParse.split(",");

        // initialize variables
        String jetType = lineArray[0].toLowerCase();
        String entityName = lineArray[1];
        int ammo = Integer.parseInt(lineArray[2]);
        double range = Double.parseDouble(lineArray[3]);

        // compare values to determine the type of aircraft
        if (jetType.equals("bomber")) {
            bomberType = lineArray[4];
            // compare the bomber type to determine if it is a jet or not
            if (bomberType.equals("jet")) {
                isJet = true;
            }
            return new Bomber(entityName, ammo, range, isJet);
        } else if (jetType.equals("fighterjet")) {
            // get the max speed
            maxSpeed = Double.parseDouble(lineArray[4]);
            return new FighterJet(entityName, ammo, range, maxSpeed);
        } else if (jetType.equals("combathelicopter")) {
            // get the min flying altitude
            minFlyingAltitude = Double.parseDouble(lineArray[4]);
            return new CombatHelicopter(entityName, ammo, range, minFlyingAltitude);
        } else {
            return null;
        }
    }
}
