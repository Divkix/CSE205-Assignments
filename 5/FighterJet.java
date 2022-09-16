/*
 Assignment #: 5
         Name: Divanshu Chauhan
    StudentID: 1224087311
      Lecture: MW 1:30PM-2:45PM
  Description: FighterJet class represents a bomber aircraft and extends the AircraftEntity class
*/

public class FighterJet extends AircraftEntity {
    // initialize variables
    private double maxSpeed;

    // constructor
    public FighterJet() {
        super();
    }

    // constructor with parameters
    public FighterJet(String entityName, int ammo, double range, double maxSpeed) {
        super(entityName, ammo, range);
        this.maxSpeed = maxSpeed;
    }

    // override the computeAttackPower method
    public void computeAttackPower() {
        this.attackPower = (int) ((ammo + range) * (maxSpeed/10));
    }

    // override the toString method
    public String toString() {
        return "Fighter Jet:\n" +
               super.toString() +
               "Maximum Speed:\t"+ this.maxSpeed + "%\n";
    }
}
