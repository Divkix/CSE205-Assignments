// Assignment 12: Arizona State University CSE205
//         Name: Divanshu Chauhan
//    StudentID: 1224807311
//      Lecture: MW 1:30-2:45PM
//  Description: WaveDisplayPane class for assignment 12


package me.divkix.assignment12;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class WaveDisplayPane extends Pane {

    // Task #1: implement instance variables, constructor, and methods
    // as outlined in the UML diagram and assignment description

    // declare the variables
    private Timeline timeline;
    private int time;
    private int waveLength;
    private int waveAmplitude;
    private int paneWidth;
    private Color color;

    // Implement the WaveDisplayPane class constructor.
    // The constructor initializes the wave amplitude to 100,
    // the wavelength to 50, the width of the pane that is used
    // to draw the waves to the value from the parameter list,
    // the color to the value from the parameter list, and time to 0 (zero).
    // The background of the pane should be WHITE and the color of the border
    // should be BLACK (you can use the setStyle() method).
    public WaveDisplayPane(int width, Color color) {
        // set waveAmplitude to 100
        this.waveAmplitude = 100;
        // set waveLength to 50
        this.waveLength = 50;
        // set paneWidth to the value from the parameter list
        this.paneWidth = width;
        // set color to the value from the parameter list
        this.color = color;
        // set time to 0
        this.time = 0;
        // set the background of the pane to WHITE and the color of the border to BLACK
        this.setStyle("-fx-background-color: white; -fx-border-color: black");
        // Instantiate a KeyFrame object that will be executed sequentially at time interval 500 milliseconds and is registered with a WaveHandler object
        this.timeline = new Timeline();
        // set the cycle count to indefinite
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        // set the keyframe to 500 milliseconds
        this.timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new WaveHandler()));
        // set the rate to 20
        this.timeline.setRate(20);
        // play the timeline
        this.resume();
    }

    // plays the timeline
    public void resume() {
        this.timeline.play();
    }

    // pauses an animation and resets the time to 0 (zero)
    public void suspend() {
        this.timeline.pause();
        this.time = 0;
    }

    // sets a new color for the wave
    public void setColor(Color color) {
        this.color = color;
    }

    // removes all waves from the pane and suspends the animation
    public void clear() {
        this.getChildren().clear();
        this.suspend();
    }

    // setter for the wave length
    public void setWaveLength(int waveLength) {
        this.waveLength = waveLength;
    }

    // setter for the wave amplitude
    public void setWaveAmplitude(int waveAmplitude) {
        this.waveAmplitude = waveAmplitude;
    }

    // setter for the time rate
    public void setRate(int rate) {
        this.timeline.setRate(rate);
    }

    // defines an event listener to draw a new point
    private class WaveHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            time++;
            int x = (waveLength * time) / 314;
            int y = (int) (waveAmplitude * Math.sin((0.0174533) * time) + 115);

            if (x < paneWidth) {
                Circle dot = new Circle(x, y, 2);
                dot.setFill(color);
                getChildren().add(dot);
            } else suspend();
        }
    }
}
