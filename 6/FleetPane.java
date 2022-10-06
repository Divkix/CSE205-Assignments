// Assignment #: 6
//         Name: Divanshu Chauhan
//    StudentID: 1224087311
//      Lecture: MW 1:30PM-2:45PM
//  Description: The FleetPane class creates a pane with a list of
//               aircrafts and a checkbot to select our fleet

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FleetPane extends BorderPane {
    // COMPLETED: contains a list of aircrafts
    ArrayList<Aircraft> aircraftList;
    // COMPLETED: Variables containing fleet Stealth Index, Bomb Carrying Capacity,
    // and Attack Power
    int totalStealthIndex;
    int totalBombCarryingCapacity;
    int totalAttackPower;

    // TODO 5. a) "Declare" (Do not "initialize" them yet!!!)
    // ONE Label to display Fleet information
    // ONE VBox to contain CheckBoxes
    // ONE "Load Aircrafts/Clear Selection" Button
    // vvvvvv 5. a) vvvvvv (about 3 lines)
    // declare labels
    Label fleetInfo;
    VBox aircraftCheckBoxes;
    Button loadAircraftsButton;
    // ^^^^^^ 5. a) ^^^^^^
    public FleetPane(ArrayList<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
        // TODO 5. a) Initialize the instance variables
        // This is where you use the "new" keyword
        // vvvvvv 5. a) vvvvvv (about 3 lines)
        // initialize labels
        fleetInfo = new Label("Select aircrafts to add to your fleet");
        aircraftCheckBoxes = new VBox();
        loadAircraftsButton = new Button("Load Aircrafts/Clear Selection");
        // ^^^^^^ 5. a) ^^^^^^
        // TODO: 5. b) Bind "Load Aircrafts/Clear Selection" Button to its handler
        // vvvvvv 5. b) vvvvvv (1 line)
        // bind button to handler
        loadAircraftsButton.setOnAction(new LoadAircraftsButtonHandler());
        // ^^^^^^ 5. b) ^^^^^^
        // TODO: 5. c) Organize components to their positions on BorderPane
        // Remeber that THIS class "is"/extends BorderPane, use BorderPane syntax to add
        // components
        // vvvvvv 5. c) vvvvvv (1 line)
        // add components to pane
        this.setTop(fleetInfo);
        this.setCenter(aircraftCheckBoxes);
        this.setBottom(loadAircraftsButton);
        // ^^^^^^ 5. c) ^^^^^^
    }

    private class LoadAircraftsButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // TODO: 6. Clear the VBox (1 line)
            // vvvvvv 6. a) vvvvvv (1 line)
            // clear the VBox
            aircraftCheckBoxes.getChildren().clear();
            // ^^^^^^ 6. a) ^^^^^^
            // TODO: 6. b), c), d)
            // vvvvvv 6. b), c), d) vvvvvv (about 5-8 lines)
            // loop through aircraftList and create a CheckBox for each aircraft
            for (Aircraft aircraft : aircraftList) {
                CheckBox aircraftCheckBox = new CheckBox(aircraft.toString());
                aircraftCheckBox.setOnAction(new CheckBoxHandler(aircraft));
                aircraftCheckBoxes.getChildren().add(aircraftCheckBox);
            }
            // ^^^^^^ 6. b), c), d) ^^^^^^
        }
    }

    private class CheckBoxHandler implements EventHandler<ActionEvent> {
        Aircraft aircraft;
        // When creating a new CheckBoxHandler, pass in a Aircraft object so it can be
        // accessed later

        public CheckBoxHandler(Aircraft _aircraft) {
            this.aircraft = _aircraft;
        }

        @Override
        public void handle(ActionEvent event) {
            // TODO: 7. a) Use event.getSource() to get the CheckBox that triggered the
            // event, cast it to CheckBox
            // vvvvvv 7. a) vvvvvv (1 line)
            // get the CheckBox that triggered the event
            CheckBox checkBox = (CheckBox) event.getSource();
            // ^^^^^^ 7. a) ^^^^^^
            // TODO: 7. b) If the CheckBox was selected, add the current aircraft scores to
            // totalBombCarryingCapacity,
            // totalAttackPower, and totalStealthIndex. Otherwise, subtract the current
            // aircraft scores
            // vvvvvv 7. b) vvvvvv (about 8-12 lines)
            // if the CheckBox was selected, add the current aircraft scores to totalBombCarryingCapacity, totalAttackPower, and totalStealthIndex
            if (checkBox.isSelected()) {
                totalBombCarryingCapacity += aircraft.getBombCarryingCapacity();
                totalAttackPower += aircraft.getAttackPower();
                totalStealthIndex += aircraft.getStealthIndex();
            } else {
                // if the CheckBox was deselected, subtract the current aircraft scores from totalBombCarryingCapacity, totalAttackPower, and totalStealthIndex
                totalBombCarryingCapacity -= aircraft.getBombCarryingCapacity();
                totalAttackPower -= aircraft.getAttackPower();
                totalStealthIndex -= aircraft.getStealthIndex();
            }
            // ^^^^^^ 7. b) ^^^^^^
            // TODO: 7. c) Set the Label to
            // "Total Stealth Index: " + totalStealthIndex + "\t\tTotal Bomb Carrying
            // Capacity: " + totalBombCarryingCapacity + "\tTotal Attack Power: " +
            // totalAttackPower
            // vvvvvv 7. c) vvvvvv (1 line)
            // set the desired label in the format specified in fleetInfo
            fleetInfo.setText("Total Stealth Index: " + totalStealthIndex +
                                "\t\tTotal Bomb Carrying Capacity: " + totalBombCarryingCapacity +
                                "\tTotal Attack Power: " + totalAttackPower);
            // ^^^^^^ 7. c) ^^^^^^
        }
    }
}
