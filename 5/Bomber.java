/*
 Assignment #: 5
         Name: Divanshu Chauhan
    StudentID: 1224087311
      Lecture: MW 1:30PM-2:45PM
  Description: Bomber class represents a bomber aircraft and extends the AircraftEntity class
*/

public class Bomber extends AircraftEntity {
    // initialize variables
    private int bombCarryingCapacity;
    private double maxFlyingAltitude;
    private boolean isJet;

    // constructor
    public Bomber() {
        super();
    }

    // constructor with parameters
    public Bomber(String entityName, int ammo, double range, boolean isJet) {
        super(entityName, ammo, range);
        if (isJet) {
            this.bombCarryingCapacity = 100;
            this.maxFlyingAltitude = 45.5;
        } else {
            this.bombCarryingCapacity = 75;
            this.maxFlyingAltitude = 34.0;
        }
    }

    // override the computeAttackPower method
    public void computeAttackPower() {
        if (this.maxFlyingAltitude >= 40) {
            this.attackPower = (int)  ((maxFlyingAltitude + ammo) * (bombCarryingCapacity/100));
        } else {
            this.attackPower = (int) ((ammo + range) * (bombCarryingCapacity/100));
        }
    }

    // override the toString method
    public String toString() {
        String returnString = "Bomber:\t";
        if (this.isJet) {
            returnString += "Jet Type\n";
        } else {
            returnString += "Propeller Type\n";
        }
        returnString = returnString +
                        "\n" +
                        super.toString() +
                        "Bomb Carrying Capacity:\t" +
                        this.bombCarryingCapacity + "%\n";
        return returnString;
    }
}
