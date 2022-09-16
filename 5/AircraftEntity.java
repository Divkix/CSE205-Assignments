/*
 Assignment #: 5
         Name: Divanshu Chauhan
    StudentID: 1224087311
      Lecture: MW 1:30PM-2:45PM
  Description: AircraftEntity class is the base class to which other classes extend from.
*/

abstract public class AircraftEntity {
    // initialize variables
    protected String entityName;
    protected int ammo;
    protected double range;
    protected int attackPower;

    // constructor
    public AircraftEntity() {
        this.entityName = "";
        this.ammo = 0;
        this.range = 0;
        this.attackPower = 0;
    }

    // constructor with parameters
    public AircraftEntity(String entityName, int ammo, double range) {
        this.entityName = entityName;
        this.ammo = ammo;
        this.range = range;
        this.attackPower = 0;
    }

    // get the attack power of the aircraft
    public int getAttackPower() {
        return this.attackPower;
    }

    // set the attack power of the aircraft
    public abstract void computeAttackPower();

    // convert aircraft info to string
    public String toString() {
        return "Aircraft name:\t" + this.entityName +
               "\nCurrent Ammo:\t" + this.ammo +
               "\nRange:\t" + this.range +
               "\nCurrent Attack Power:\t" + this.attackPower +
               "\n";
    }
}
