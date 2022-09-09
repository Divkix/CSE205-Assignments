class Manager {
    // Instance variables
    public String firstName;
    public String lastName;
    public int yearsExperience;
    public String managingSince;

    // Constructors
    public Manager() {
        firstName = "";
        lastName = "";
        yearsExperience = 0;
        managingSince = "";
    }

    // Constructor with parameters
    public Manager(String firstName, String lastName, int yearsExperience, String managingSince) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsExperience = yearsExperience;
        this.managingSince = managingSince;
    }

    // Get first name of the manager
    public String getFirstName() {
        return firstName;
    }

    // Get last name of the manager
    public String getLastName() {
        return lastName;
    }

    // Get years of experience of the manager
    public int getYearsExperience() {
        return yearsExperience;
    }

    // Get managing since of the manager
    public String getManagingSince() {
        return managingSince;
    }

    // Set first name of the manager
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Set last name of the manager
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Set years of experience of the manager
    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    // Set managing since of the manager
    public void setManagingSince(String managingSince) {
        this.managingSince = managingSince;
    }

    // Return a string with the manager's information
    public String toString() {
        return "\nLast Name:\t"+this.lastName+"\nFirst Name:\t"+this.firstName+"\nYears of Experience:\t"+this.yearsExperience+"\nManaging Since:\t"+this.managingSince+"\n";
    }
}
