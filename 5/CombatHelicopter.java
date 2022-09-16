/*
 Assignment #: 5
         Name: Divanshu Chauhan
    StudentID: 1224087311
      Lecture: MW 1:30PM-2:45PM
  Description: CombatHelicopter class represents a bomber aircraft and extends the AircraftEntity class
*/

public class CombatHelicopter extends AircraftEntity {
    // initialize variables
    private double minFlyingAltitude;
    private int stealthIndex;

    // constructor
    public CombatHelicopter() {
        super();
    }

    // constructor with parameters
    public CombatHelicopter(String entityName, int ammo, double range, double minFlyingAltitude) {
        super(entityName, ammo, range);
        this.minFlyingAltitude = minFlyingAltitude;
        if (this.minFlyingAltitude < 5) {
            this.stealthIndex = 10;
        } else {
            this.stealthIndex = 7;
        }
    }

    // override the computeAttackPower method
    public void computeAttackPower() {
        this.attackPower = (int) ((minFlyingAltitude + ammo + range) * (stealthIndex));
    }

    public String toString() {
        return "Combat Helicopter\n" +
               super.toString() +
               "Stealth Index:\t" +
                this.stealthIndex +
                "\n";
    }
}
