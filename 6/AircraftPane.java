// Assignment #: 6
//         Name: Divanshu Chauhan
//    StudentID: 1224087311
//      Lecture: MW 1:30PM-2:45PM
//  Description: The AircraftPane class creates a Pane with
//               a form to add an aircraft

import java.io.FileInputStream;
import java.util.Random;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
// There are 4 (FOUR) tasks to be completed in this file - Look for TODO:keywords
// TODO: 1. Build the GUI
// TODO: 2. Write "Random" Button Handler
// TODO: 3. "Add New Aircraft" button handler - Check for valid input
// beforeadding the new Aircraft to the list:
// TODO: 4. Update rightTextArea with updated information fromaircraftList

public class AircraftPane extends HBox {
    // COMPLETED: contains a list of aircrafts
    ArrayList<Aircraft> aircraftList;
    // COMPLETED: Save current Aircraft Type
    String selectedAircraftType;
    // COMPLETED: Main layout components
    TextArea rightTextArea;
    VBox leftVBox;
    ComboBox<String> aircraftTypeComboBox;
    ImageView imageView;
    // TODO 1. a) "Declare" (Do not "initialize" them yet!!!)
    // ONE GridPane to hold
    // FOUR Labels (Name, Bomb Carrying Capacity, Attack Power, Stealth Index),
    // FOUR corresponding TextFields
    // ONE "Random" Button
    // vvvvvv 1. a) vvvvvv (about 8-12 lines)
    GridPane inputPane;
    Label nameLabel;
    Label bombCapacityLabel;
    Label attackPowerLabel;
    Label stealthIndexLabel;
    TextField nameTextField;
    TextField bombCapacityTextField;
    TextField attackPowerTextField;
    TextField stealthIndexTextField;
    Button randomButton;
    // ^^^^^^ 1. a) ^^^^^^

    // TODO 1. b) "Declare" (Do not "initialize" them yet!!!)
    // ONE "Add New Aircraft!!!" Button
    // ONE red Label to display add aircraft status.
    // vvvvvv 1. b) vvvvvv (about 2 lines)
    Button addNewAircraftButton;
    Label addAircraftStatus;
    // ^^^^^^ 1. b) ^^^^^^

    // COMPLETED: Define window size
    public static final int WINSIZE_X = 1000, WINSIZE_Y = 600;
    // Constructor - what to do when AircraftPane is first created

    public AircraftPane(ArrayList<Aircraft> aircraftList) {
        // COMPLETED: Assign the aircraftList passed into this constructor
        this.aircraftList = aircraftList;
        // COMPLETED: Initialize main layout components
        this.leftVBox = new VBox();
        this.rightTextArea = new TextArea();

        // COMPLETED: Setting up ComboBox
        String[] aircraftType = { "Fighter Jet", "Bomber - Propeller Type", "Bomber - Jet Type", "Combat Helicopter" };
        aircraftTypeComboBox = new ComboBox<String>();
        aircraftTypeComboBox.setValue("Select Aircraft Type");
        aircraftTypeComboBox.getItems().addAll(aircraftType);
        aircraftTypeComboBox.setOnAction(new AircraftTypeComboBoxHandler());
        leftVBox.getChildren().add(aircraftTypeComboBox);

        // TODO 1. a) Initialize the instance variables
        // This is where you use the "new" keyword
        // vvvvvv 1. a) vvvvvv (about 8-12 lines)
        inputPane = new GridPane();
        nameLabel = new Label("Name");
        bombCapacityLabel = new Label("Bomb Carrying Capacity");
        attackPowerLabel = new Label("Attack Power");
        stealthIndexLabel = new Label("Stealth Index");
        nameTextField = new TextField();
        bombCapacityTextField = new TextField();
        attackPowerTextField = new TextField();
        stealthIndexTextField = new TextField();
        randomButton = new Button("Random");
        // ^^^^^^ 1. a) ^^^^^^

        // TODO 1. b) Initialize the instance variables and set Label color to RED
        // vvvvvv 1. b) vvvvvv (about 3 lines)
        Button addNewAircraftButton = new Button("Add New Aircraft!!!");
        addAircraftStatus = new Label();
        addAircraftStatus.setTextFill(Color.RED);
        // ^^^^^^ 1. b) ^^^^^^

        // TODO 1. c) Organize Labels, TextFields, and Button onto the GridPane
        // vvvvvv 1. c) vvvvvv (about 8-12 lines)
        inputPane = new GridPane();
        inputPane.add(nameLabel, 0, 0);
        inputPane.add(bombCapacityLabel, 0, 1);
        inputPane.add(attackPowerLabel, 0, 2);
        inputPane.add(stealthIndexLabel, 0, 3);
        inputPane.add(nameTextField, 1, 0);
        inputPane.add(bombCapacityTextField, 1, 1);
        inputPane.add(attackPowerTextField, 1, 2);
        inputPane.add(stealthIndexTextField, 1, 3);
        inputPane.add(randomButton, 2, 0);
        // ^^^^^^ 1. c) ^^^^^^

        // TODO: 1. d) Bind buttons to their handlers (RandomButtonHandler and
        // AddNewAircraftButtonHandler)
        // vvvvvv 1. d) vvvvvv (about 2 lines)
        randomButton.setOnAction(new RandomButtonHandler());
        addNewAircraftButton.setOnAction(new AddNewAircraftButtonHandler());
        // ^^^^^^ 1. d) ^^^^^^

        // TODO: 1. e) Add GridPane, Button, and red Label to leftVBox
        // vvvvvv 1. e) vvvvvv (about 1-3 lines)
        leftVBox.getChildren().add(inputPane);
        leftVBox.getChildren().add(addNewAircraftButton);
        leftVBox.getChildren().add(addAircraftStatus);
        // ^^^^^^ 1. e) ^^^^^^
        // COMPLETED: VBox layout alignment
        inputPane.setHgap(20);
        leftVBox.setPadding(new Insets(40, 50, 0, 50));
        leftVBox.setSpacing(40);
        leftVBox.setAlignment(Pos.TOP_CENTER);
        leftVBox.setPrefWidth(WINSIZE_X / 2);
        // COMPLETED: Setting up ImageView
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(100);
        leftVBox.getChildren().add(imageView);
        FileInputStream input;
        try {
            input = new FileInputStream("fighter jet.png");
            Image image = new Image(input);
            imageView.setImage(image);
        } catch (FileNotFoundException e) {
            imageView.setImage(null);
        }

        // COMPLETED: Add main components to "Add Aircraft" tab
        this.getChildren().addAll(leftVBox, rightTextArea);
    }
    // We have finished setting up the GUI for Add Aircraft tab, let's move on to
    // the
    // logic/back-end side!
    // Writing handlers

    // Generate random stealth index value (1 <= stealthIndex <= 10)
    private class RandomButtonHandler implements
            EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            // TODO: 2. Write "Random" Button Handler
            // vvvvvv 2. vvvvvv (about 8-12 lines)
            Button randomButton = new Button("Random");
            Random rand = new Random();
            int stealthIndex = rand.nextInt(10) + 1;
            stealthIndexTextField.setText(Integer.toString(stealthIndex));
            // ^^^^^^ 2. ^^^^^^
        }
    }

    // TODO 3. "Add New Aircraft" button handler - Check for valid inputbefore
    // adding the new Aircraft to the list
    // vvvvvv 3. vvvvvv (about 20-30 lines)
    private class AddNewAircraftButtonHandler implements EventHandler<ActionEvent> {
        // This method will be called once we click the button
        public void handle(ActionEvent event) {
            // TODO 3. a) Create 4 String variables and assign them to the values retrieved
            // from TextFields using .getText()
            // vvvvvv 3. a) vvvvvv (about 4 lines)
            String name = nameTextField.getText();
            String bombCapacity = bombCapacityTextField.getText();
            String attackPower = attackPowerTextField.getText();
            String stealthIndex = stealthIndexTextField.getText();
            // ^^^^^^ 3. a) ^^^^^^
            // "Always sanitize user input"
            // You need to make sure the input is valid, for example:
            // - Not empty
            // - In the correct format (String, Integer, Double, etc)
            // - Satisfied all input requirement (non-negative, between a range, etc)
            // Use this try/catch block AND "throw new Exception()" to handle invalid input
            try {

                // EXAMPLE: When the aircraft type is not selected
                if (selectedAircraftType == null) {
                    // When you throw a new Exception, the program STOPS immediately
                    // and SKIPS to the catch{} block, so the lines below will NOT execute.
                    // Check out the catch{} block below
                    throw new Exception("Aircraft type is not yet selected");
                }
                // TODO: 3. b) If one of the TextFields is empty, throw exception with
                // error message: "At least one of the text fields is empty"
                // vvvvvv 3. b) vvvvvv (about 4 lines)
                if (name.equals("") || bombCapacity.equals("") || attackPower.equals("") || stealthIndex.equals("")) {
                    throw new Exception("At least one of the text fields is empty");
                }
                // ^^^^^^ 3. b) ^^^^^^
                // TODO: 3. c) Loop through aircraftList to check for aircraft that has the same
                // name; throw exception with
                // error message: "Aircaft existed!"
                // vvvvvv 3. c) vvvvvv (about 5 lines)
                for (Aircraft aircraft : aircraftList) {
                    if (aircraft.getName().equals(name)) {
                        throw new Exception("Aircraft existed!");
                    }
                }
                // ^^^^^^ 3. c) ^^^^^^

                // TODO: 3. d) Now try to parse Bomb Carryig Capacity, Attack Power, and Stealth
                // Index to integers
                // The parseInt method will automatically throw error for you if the input is
                // not in the integer format
                // Create 3 integers and convert the Strings from 3. a)
                // vvvvvv 3. d) vvvvvv (about 3 lines)
                int bombCapacityInt = Integer.parseInt(bombCapacity);
                int attackPowerInt = Integer.parseInt(attackPower);
                int stealthIndexInt = Integer.parseInt(stealthIndex);
                // ^^^^^^ 3. d) ^^^^^^

                // TODO: 3. e) Check if Bomb Carrying Capacity or Attack Power is a negative
                // number
                // if so, throw exception with error message "Both Bomb Carrying Capacity and
                // Attack Power must be positive numbers"
                // vvvvvv 3. e) vvvvvv (about 3 lines)
                if (bombCapacityInt < 0 || attackPowerInt < 0) {
                    throw new Exception("Both Bomb Carrying Capacity and Attack Power must be positive numbers");
                }
                // ^^^^^^ 3. e) ^^^^^^
                // TODO: 3. f) Check if the sum of Carrying Capacity and Attack Power exceeds
                // 5000.
                // If so, throw exception with error message "The sum of Carrying Capacity and
                // Attack Power must be less or equal to 5000"
                // vvvvvv 3. f) vvvvvv (about 3 lines)
                if (bombCapacityInt + attackPowerInt > 5000) {
                    throw new Exception("The sum of Carrying Capacity and Attack Power must be less or equal to 5000");
                }
                // ^^^^^^ 3. f) ^^^^^^

                // TODO: 3. g) Input is valid, now create newAircraft object (remember to check
                // out Aircraft.java file)
                // with data from user input. Don't forget "selectedAircraftType"
                // Finally, add the newly created aircraft to aircraftList
                // vvvvvv 3. g) vvvvvv (about 2-8 lines, depends on your implementation)
                Aircraft newAircraft = new Aircraft(selectedAircraftType, name, bombCapacityInt, attackPowerInt, stealthIndexInt);
                aircraftList.add(newAircraft);
                // ^^^^^^ 3. g) ^^^^^^

                // TODO 3: Set the Red Label to "Aircraft added successfully" and empty all
                // TextFields
                // vvvvvv 3. h) vvvvvv (about 5 lines)
                addAircraftStatus.setText("Aircraft added successfully");
                nameTextField.setText("");
                bombCapacityTextField.setText("");
                attackPowerTextField.setText("");
                stealthIndexTextField.setText("");
                // ^^^^^^ 3. h) ^^^^^^
                // TODO 4. b) Call updateTextArea() to update aircrafts list
                // vvvvvv 4. b) vvvvvv (1 line)
                updateTextArea();
                // ^^^^^^ 4. b) ^^^^^^
            } catch (

            NumberFormatException exception) {
                // set RED LABEL to "At least one of the text fields is in the incorrect format"
                // vvvvvv 3. d) vvvvvv (1 line)
                addAircraftStatus.setText("At least one of the text fields is in the incorrect format");
                // ^^^^^^ 3. d) ^^^^^^
            } catch (Exception exception) {
                // TODO: 3. b) The message that we passed in "throw new Exception(MESSAGE);"
                // above
                // can be retrieved using exception.getMessage()
                // Set the value of the RED LABEL to exception.getMessage() to display error
                // message
                // vvvvvv 3. b) vvvvvv (1 line)
                addAircraftStatus.setText(exception.getMessage());
                // ^^^^^^ 3. b) ^^^^^^
            }
        }

    }

    // TODO 4. a) Create a String containing all aircraft information
    // and loop through aircraftList to add all aircrafts' data together
    private void updateTextArea() {
        // vvvvvv 4. a) vvvvvv (about 5-10 lines)
        String aircrafts = "";
        for (Aircraft aircraft : aircraftList) {
            aircrafts += aircraft.toString();
        }
        // set the text of the TextArea to the String you created
        rightTextArea.setText(aircrafts);
        // ^^^^^^ 4. a) ^^^^^^
    }
    // Completed: AircraftTypeComboBoxHandler - You don't need to modify this
    // handler

    private class AircraftTypeComboBoxHandler implements
            EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            selectedAircraftType = aircraftTypeComboBox.getSelectionModel().getSelectedItem();
            FileInputStream input;
            try {
                input = new FileInputStream(selectedAircraftType.toLowerCase() + ".png");
                Image image = new Image(input);
                imageView.setImage(image);
            } catch (FileNotFoundException e) {
                imageView.setImage(null);
            }
        }
    }
}
