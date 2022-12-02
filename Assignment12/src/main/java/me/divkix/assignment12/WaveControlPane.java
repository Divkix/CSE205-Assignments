// Assignment 12: Arizona State University CSE205
//         Name: Divanshu Chauhan
//    StudentID: 1224807311
//      Lecture: MW 1:30-2:45PM
//  Description: WaveControlPane class for assignment 12

package me.divkix.assignment12;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class WaveControlPane extends Pane {


    // declare variables
    private WaveDisplayPane wavePane;
    private int width, height;
    private Color color;
    private ColorPicker picker;

    // ******************************************************************
    // Task #2a: add instance variables for sliders, buttons, and labels
    // ******************************************************************

    // Instantiate 4 buttons “Start”, “Stop”, “Clear”, and “Default”.
    // To enable all the buttons to be resized to the width of the VBox pane,
    // the maximum width of each button should be set to the Double.MAX_VALUE constant.
    // Add the buttons to the VBox buttonPane provided in the template.
    private Button startButton = new Button("Start");
    private Button stopButton = new Button("Stop");
    private Button clearButton = new Button("Clear");
    private Button defaultButton = new Button("Default");

    // Instantiate 3 vertical sliders
    // The first slider should be labelled “Speed”.
    // It will be used to adjust the speed of the animation.
    // It should have major tick spacing 10, minor tick spacing 5,
    // a minimum value of 10, a maximum value of 50, and initially be set to 20.
    // The second slider should have a label “Width”.
    // It will be used to adjust the wavelength of the wave.
    // It should have major tick spacing 10, minor tick spacing 5,
    // a minimum value of 20, a maximum value of 100, and initially be set to 50.
    // The third slider should have a label “Height”.
    // It will be used to adjust the amplitude of the wave.
    // It should have major tick spacing 10, minor tick spacing 5,
    // a minimum value of 20, a maximum value of 100, and initially be set to 80.
    private Slider speedSlider = new Slider(10, 50, 20);
    private Slider widthSlider = new Slider(20, 100, 50);
    private Slider heightSlider = new Slider(20, 100, 80);

    // Added labels for sliders
    private Label speedLabel = new Label("Speed");
    private Label widthLabel = new Label("Width");
    private Label heightLabel = new Label("Height");

    // constructor to create all components, set their handler/listener,
    // and arrange them using layout panes.
    public WaveControlPane(int h, int w, Color initialColor) {
        // set the color, width and height of the pane
        this.color = initialColor;
        this.width = (int) (h * 0.68);
        this.height = w - 10;

        // creates a pane to display waves with the specified color and set the size
        wavePane = new WaveDisplayPane(width, color);
        wavePane.setMinSize(width, height);
        wavePane.setMaxSize(width, height);

        // create a color picker with the specified initial color
        picker = new ColorPicker(color);
        // set the color picker to be the same size as the wave display pane
        picker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // ************************************************************************
        // Task #2b: create 4 buttons and resize them to the width of the VBox pane,
        // then add them to the VBox buttonPane instantiated below.
        // *************************************************************************
        // Instantiate 4 buttons “Start”, “Stop”, “Clear”, and “Default”.
        // To enable all the buttons to be resized to the width of the VBox pane,
        // the maximum width of each button should be set to the Double.MAX_VALUE constant.
        // Add the buttons to the VBox buttonPane provided in the template.
        startButton.setMaxWidth(Double.MAX_VALUE);
        stopButton.setMaxWidth(Double.MAX_VALUE);
        clearButton.setMaxWidth(Double.MAX_VALUE);
        defaultButton.setMaxWidth(Double.MAX_VALUE);

        // Create a VBox pane to hold the buttons
        VBox buttonPane = new VBox(10, picker);
        buttonPane.setPrefSize(100, 100);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setPadding(new Insets(10, 10, 10, 10));
        buttonPane.getChildren().addAll(startButton, stopButton, clearButton, defaultButton);

        // ************************************************************************
        // Task #2c: create 3 sliders and 3 labels and add them to the VBox panes
        // instantiated below.
        // *************************************************************************
        // Instantiate 3 vertical sliders and 3 labels.The first slider should be labelled “Speed”.
        // It will be used to adjust the speed of the animation. It should have major tick spacing 10,
        // minor tick spacing 5, a minimum value of 10, a maximum value of 50, and initially be set to 20.
        // The second slider should have a label “Width”. It will be used to adjust the wavelength of the wave.
        // It should have major tick spacing 10, minor tick spacing 5, a minimum value of 20, a maximum value
        // of 100, and initially be set to 50. The third slider should have a label “Height”. It will be used to
        // adjust the amplitude of the wave. It should have major tick spacing 10, minor tick spacing 5, a minimum
        // value of 20, a maximum value of 100, and initially be set to 80.
        // Add the speed label and slider to the VBox speedSliderPane, the width label and slider to the VBox
        // waveLengthSliderPane, and the height label and slider to the VBox waveAmplitudeSliderPane.

        // speedSlider settings
        speedSlider.setOrientation(Orientation.VERTICAL);
        speedSlider.setShowTickLabels(true);
        speedSlider.setShowTickMarks(true);
        speedSlider.setMajorTickUnit(10);
        speedSlider.setMinorTickCount(5);
        speedSlider.setBlockIncrement(1);

        // widthSlider settings
        widthSlider.setOrientation(Orientation.VERTICAL);
        widthSlider.setShowTickLabels(true);
        widthSlider.setShowTickMarks(true);
        widthSlider.setMajorTickUnit(20);
        widthSlider.setMinorTickCount(5);
        widthSlider.setBlockIncrement(1);

        // heightSlider settings
        heightSlider.setOrientation(Orientation.VERTICAL);
        heightSlider.setShowTickLabels(true);
        heightSlider.setShowTickMarks(true);
        heightSlider.setMajorTickUnit(20);
        heightSlider.setMinorTickCount(5);
        heightSlider.setBlockIncrement(1);

        // Create a VBox pane to hold the speed label and slider for each of the sliders
        VBox speedSliderPane = new VBox(10, speedLabel, speedSlider);
        VBox waveLengthSliderPane = new VBox(10, widthLabel, widthSlider);
        VBox waveAmplitudeSliderPane = new VBox(10, heightLabel, heightSlider);

        // create a TilePane to hold the 3 sliders and 3 labels, align it to the center
        TilePane sliderPane = new TilePane();
        sliderPane.setPrefColumns(3);
        sliderPane.setPadding(new Insets(5, 5, 5, 5));
        sliderPane.setAlignment(Pos.CENTER);
        sliderPane.getChildren().addAll(speedSliderPane, waveLengthSliderPane, waveAmplitudeSliderPane);

        HBox controls = new HBox(buttonPane, sliderPane);
        controls.setAlignment(Pos.CENTER);

        // create a BorderPane to hold the wave display pane and the controls
        BorderPane controlsAndWaves = new BorderPane();
        controlsAndWaves.setLeft(controls);
        controlsAndWaves.setCenter(wavePane);
        this.getChildren().add(controlsAndWaves);

        // ************************************************************************
        // Task #2d: Register the buttons, sliders, and color picker with the
        // appropriate handler object
        // *************************************************************************
        // Set an appropriate handler object to the buttons, the color picker, and the sliders.
        startButton.setOnAction(new ButtonHandler());
        stopButton.setOnAction(new ButtonHandler());
        clearButton.setOnAction(new ButtonHandler());
        defaultButton.setOnAction(new ButtonHandler());
        picker.setOnAction(new ColorHandler());
        speedSlider.valueProperty().addListener(new SpeedHandler());
        widthSlider.valueProperty().addListener(new WaveLengthHandler());
        heightSlider.valueProperty().addListener(new WaveAmplitudeHandler());
    }

    // class to handle ColorPicker events
    private class ColorHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            wavePane.setColor(((ColorPicker) e.getSource()).getValue());
        }
    }

    // class to handle SpeedSlider events
    private class SpeedHandler implements ChangeListener<Number> {
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            wavePane.setRate(newValue.intValue());
        }
    }

    // class to handle WaveAmplitudeSlider events
    private class WaveAmplitudeHandler implements ChangeListener<Number> {
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            wavePane.setWaveAmplitude(newValue.intValue());
        }
    }

    // class to handle WaveLengthSlider events
    private class WaveLengthHandler implements ChangeListener<Number> {
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            wavePane.setWaveLength(newValue.intValue());
        }
    }

    // class to handle Button events
    public class ButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            // Get the source of the event
            Object source = event.getSource();

            if (source == startButton) {
                // User clicks the “Start” button: The animation should resume.
                wavePane.resume();
            } else if (source == stopButton) {
                // User clicks the “Stop” button: The animation should be suspended.
                wavePane.suspend();
            } else if (source == clearButton) {
                // User clicks the “Clear” button: The pane should be cleared (all waves should be removed).
                wavePane.suspend();
                wavePane.clear();
            } else if (source == defaultButton) {
                // user clicks the "default" button
                wavePane.suspend();
                wavePane.setWaveAmplitude(60);
                wavePane.setWaveLength(50);
                wavePane.setRate(30);
                wavePane.setColor(Color.RED);
                wavePane.resume();
            }
        }
    }
}
