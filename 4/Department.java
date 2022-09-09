/* Assignment #: 4
         Name: Divanshu Chauhan
    StudentID: 1224087311
      Lecture: MW 1:30PM-2:45PM
 Description: Department class creates a department object with
              name, manager, division and locarion.
 */

class Department {
    // Instance variables
    public String name;
    public Manager manager;
    public String division;
    public String location;

    // Constructors
    public Department() {
        // Set the default values
        name = "";
        manager = new Manager();
        division = "";
        location = "";
    }

    // Constructor with parameters
    public Department(String name, Manager manager, String division, String location) {
        this.name = name;
        this.manager = manager;
        this.division = division;
        this.location = location;
    }

    // Get name of the department
    public String getName() {
        return name;
    }

    // Get manager of the department
    public Manager getManager() {
        return manager;
    }

    // Get division of the department
    public String getDivision() {
        return division;
    }

    // Get location of the department
    public String getLocation() {
        return location;
    }

    // Set name of the department
    public void setName(String name) {
        this.name = name;
    }

    // Set manager of the department
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    // Set division of the department
    public void setDivision(String division) {
        this.division = division;
    }

    // Set location of the department
    public void setLocation(String location) {
        this.location = location;
    }

    // Return a string with the department's information
    public String toString() {
        return "Department Name:\t" + name + "\nDivision:\t" + division + "\nLocation:\t" + location
                + "\nManager Information:" + manager.toString();
    }
}