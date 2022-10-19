//   Assignment: 7, CSE205, Arizona State University
//         Name: Divanshu Chauhan
//    StudentID: 1224807311
// Lecture time: MW 1:30-2:45PM
//  Description: The main class for the Sketchy GUI.
//               This class is responsible for creating the
//               GUI and handling the events.

package me.divkix.assignment7;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class SketchPane extends BorderPane {
    // Task 1: Declare all instance variables listed in UML diagram
    private ArrayList<Shape> shapeList = new ArrayList<>();
    private ArrayList<Shape> tempList = new ArrayList<>();
    private Button undoButton;
    private Button eraseButton;
    private Label fillColorLabel;
    private Label strokeColorLabel;
    private Label strokeWidthLabel;
    private ComboBox<String> fillColorCombo;
    private ComboBox<String> strokeWidthCombo;
    private ComboBox<String> strokeColorCombo;
    private RadioButton radioButtonRectangle;
    private RadioButton radioButtonEllipse;
    private RadioButton radioButtonTriangle;
    private Pane sketchCanvas;
    private Color[] colors;
    private String[] strokeWidth;
    private String[] colorLabels;
    private Color currentStrokeColor;
    private Color currentFillColor;
    private int currentStrokeWidth;
    private Rectangle rectangle;
    private Ellipse ellipse;
    private Polygon triangle;
    private double x1;
    private double y1;

    // Task 2: Implement the constructor
    public SketchPane() {
        // Define colors, labels, stroke widths that are available to the user
        colors = new Color[]{Color.BLACK, Color.GREY, Color.YELLOW,
                Color.GOLD, Color.ORANGE, Color.DARKRED, Color.PURPLE, Color.HOTPINK, Color.TEAL,
                Color.DEEPSKYBLUE, Color.LIME};
        colorLabels = new String[]{"black", "grey", "yellow", "gold",
                "orange", "dark red", "purple", "hot pink", "teal", "deep sky blue", "lime"};
        fillColorLabel = new Label("Fill Color:");
        strokeColorLabel = new Label("Stroke Color:");
        strokeWidthLabel = new Label("Stroke Width:");
        strokeWidth = new String[]{"1", "3", "5", "7", "9", "11", "13"};

        // Create the Undo and Erase Button, register the two Buttons with the
        // ButtonHandler
        undoButton = new Button("Undo");
        undoButton.setOnAction(new ButtonHandler());
        eraseButton = new Button("Erase");
        eraseButton.setOnAction(new ButtonHandler());

        // Create 3 ComboBoxes for shape fill, stroke width, and stroke color; add the
        // available color choices and stroke width to the ComboBoxes; set the default
        // fill and stroke color to BLACK and the default stroke width to 1; register
        // the ComboBoxes with the corresponding handler (ColorHandler or WidthHandler)
        fillColorCombo = new ComboBox<String>();
        fillColorCombo.getItems().addAll(colorLabels);
        fillColorCombo.setValue("black");
        fillColorCombo.setOnAction(new ColorHandler());
        strokeColorCombo = new ComboBox<String>();
        strokeColorCombo.getItems().addAll(colorLabels);
        strokeColorCombo.setValue("black");
        strokeColorCombo.setOnAction(new ColorHandler());
        strokeWidthCombo = new ComboBox<String>();
        strokeWidthCombo.getItems().addAll(strokeWidth);
        strokeWidthCombo.setValue("1");
        strokeWidthCombo.setOnAction(new WidthHandler());

        // Create 3 RadioButtons to choose the shape to be drawn: Rectangle, Ellipse or
        // Triangle.
        radioButtonRectangle = new RadioButton("Rectangle");
        radioButtonRectangle.setOnAction(new ButtonHandler());
        radioButtonEllipse = new RadioButton("Ellipse");
        radioButtonEllipse.setOnAction(new ButtonHandler());
        radioButtonTriangle = new RadioButton("Triangle");
        radioButtonTriangle.setOnAction(new ButtonHandler());

        // Add all RadioButtons to a ToggleGroup and select the Rectangle by default
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonRectangle.setToggleGroup(toggleGroup);
        radioButtonEllipse.setToggleGroup(toggleGroup);
        radioButtonTriangle.setToggleGroup(toggleGroup);
        radioButtonRectangle.setSelected(true);

        // Instantiate sketchCanvas and set its background color to WHITE
        sketchCanvas = new Pane();
        sketchCanvas.setStyle("-fx-background-color: white");

        // Instantiate an HBox to hold the ComboBoxes. To achieve the given layout,
        // instantiate the HBox with size 20 and set the minimum size to (20,40). Use
        // pos.CENTER for alignment and set the background color of the HBox to
        // LIGHTGREY. Then, add the Labels and ComboBoxes.
        HBox hBox = new HBox(20);
        hBox.setMinSize(20, 40);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: lightgrey");
        hBox.getChildren().addAll(
                fillColorLabel,
                fillColorCombo,
                strokeColorLabel,
                strokeColorCombo,
                strokeWidthLabel,
                strokeWidthCombo
        );

        // Instantiate an HBox to hold the RadioButtons and Buttons. To achieve the
        // given layout, instantiate the HBox with size 20 and set the minimum size to
        // (20,40). Use pos.CENTER for alignment and set the background color of the
        // HBox to LIGHTGREY. Then, add the 3 Radiobuttons and 2 Buttons.
        HBox hBox1 = new HBox(20);
        hBox1.setMinSize(20, 40);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setStyle("-fx-background-color: lightgrey");
        hBox1.getChildren().addAll(radioButtonRectangle, radioButtonEllipse, radioButtonTriangle, undoButton,
                eraseButton);

        // Add the sketchCanvas Pane and the two HBox Panes to the BorderPane. The
        // shapes drawn on the sketchCanvas Pane should not hide the controls/HBox
        // Panes.
        this.setCenter(sketchCanvas);
        this.setTop(hBox);
        this.setBottom(hBox1);

        // register the sketchCanvas Pane with the MouseHandler and set the default
        // values for the remaining instance variables (x1 and y2 should be zero,
        // current stroke and fill color should be black, current stroke width should be
        // 1).
        sketchCanvas.setOnMousePressed(new MouseHandler());
        sketchCanvas.setOnMouseDragged(new MouseHandler());
        sketchCanvas.setOnMouseReleased(new MouseHandler());
        x1 = 0;
        y1 = 0;
        currentStrokeColor = Color.BLACK;
        currentFillColor = Color.BLACK;
        currentStrokeWidth = 1;
    }

    // Get the Euclidean distance between (x1,y1) and (x2,y2)
    private double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private class MouseHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            // TASK 3: Implement the mouse handler for Triangle and Ellipse
            // Rectangle Example given!
            // ellipse
            // If the mouse is pressed, grab the x and y coordinates; instantiate a new
            // ellipse; set the center coordinates of the ellipse to x and y; make the fill
            // color white and the stroke color black; add the ellipse to the shape array
            // list; and add the ellipse to sketchCanvas.
            // If the mouse is dragged, get the current x and y coordinates of the cursor,
            // calculate the Euclidean distance between the current position and the
            // position when the mouse was pressed, and set ellipse’s X radius as distance
            // and Y radius as half of the distance.
            // If the mouse is released, set the ellipse’s filling and stroke and stroke
            // width to the choices the user selected.

            if (radioButtonEllipse.isSelected()) {
                // If user chooses Ellipse, draw an ellipse
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    // Mouse is pressed
                    x1 = event.getX();
                    y1 = event.getY();
                    ellipse = new Ellipse();
                    ellipse.setCenterX(x1);
                    ellipse.setCenterY(y1);
                    ellipse.setFill(Color.WHITE);
                    ellipse.setStroke(Color.BLACK);
                    shapeList.add(ellipse);
                    sketchCanvas.getChildren().add(ellipse);
                } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    // Mouse is dragged
                    double x2 = event.getX();
                    double y2 = event.getY();
                    double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                    Ellipse ellipse = (Ellipse) shapeList.get(shapeList.size() - 1);
                    ellipse.setRadiusX(distance);
                    ellipse.setRadiusY(distance / 2);
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    // Mouse is released
                    Ellipse ellipse = (Ellipse) shapeList.get(shapeList.size() - 1);
                    ellipse.setFill(currentFillColor);
                    ellipse.setStroke(currentStrokeColor);
                    ellipse.setStrokeWidth(currentStrokeWidth);
                }
            } else if (radioButtonRectangle.isSelected()) {
                // If user chooses Rectangle, draw a rectangle
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    // Mouse is pressed
                    x1 = event.getX();
                    y1 = event.getY();
                    rectangle = new Rectangle();
                    rectangle.setX(x1);
                    rectangle.setY(y1);
                    shapeList.add(rectangle);
                    rectangle.setFill(Color.WHITE);
                    rectangle.setStroke(Color.BLACK);
                    sketchCanvas.getChildren().add(rectangle);
                } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    // Mouse is dragged
                    rectangle.setWidth(Math.abs(event.getX() - x1));
                    rectangle.setHeight(Math.abs(event.getY() - y1));
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    // If the Mouse is released
                    rectangle.setFill(currentFillColor);
                    rectangle.setStroke(currentStrokeColor);
                    rectangle.setStrokeWidth(currentStrokeWidth);
                }
            } else if (radioButtonTriangle.isSelected()) {
                // If user chooses Triangle, draw a triangle
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    // Mouse is pressed
                    x1 = event.getX();
                    y1 = event.getY();
                    triangle = new Polygon();
                    triangle.getPoints().addAll(x1, y1,
                            x1 + 20, y1 + 20,
                            x1 - 20, y1 + 20);
                    triangle.setFill(Color.WHITE);
                    triangle.setStroke(Color.BLACK);
                    shapeList.add(triangle);
                    sketchCanvas.getChildren().add(triangle);
                } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    // Mouse is dragged
                    triangle.getPoints().clear();
                    // create triangle with the dimensions of mouse dragged
                    triangle.getPoints().addAll(x1, y1,
                            x1 + event.getX(), y1 + event.getY(),
                            x1 - event.getX(), y1 + event.getY());
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    // If the Mouse is released
                    triangle.setFill(currentFillColor);
                    triangle.setStroke(currentStrokeColor);
                    triangle.setStrokeWidth(currentStrokeWidth);
                }
            }
        }
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // TASK 4: Implement the button handler
            // This method handles two events: 1) user pushes the Undo button; 2) user
            // pushes the Erase button.
            // If the source of the event is the Undo Button and the array list with the
            // shapes is not empty, remove the last element from the array list and also
            // remove the last element that was drawn on sketchCanvas.
            if (event.getSource() == undoButton) {
                if (!shapeList.isEmpty()) {
                    shapeList.remove(shapeList.size() - 1);
                    sketchCanvas.getChildren().remove(sketchCanvas.getChildren().size() - 1);
                }
            } else if (event.getSource() == eraseButton) {
                // If the source of the event is the Erase Button and the array list with the
                // shapes is not empty, clear the temporary array list, add all elements from
                // the shape array list to the temporary array list (as backup), clear the array
                // list with the shapes, and clear sketchCanvas.
                tempList.clear();
                tempList.addAll(shapeList);
                shapeList.clear();
                sketchCanvas.getChildren().clear();
            } else {
                // Else (if there are currently no shapes in the array list) it is possible that
                // the Erase Button was pushed previously, which deleted all the shapes. Copy
                // the elements from your temporary array list into the array list with the
                // shapes, clear the temporary array list, and add all the shapes from the array
                // list to sketchCanvas. This ensures that all shapes reappear if the user wants
                // to undo an erase event.
                if (shapeList.isEmpty()) {
                    shapeList.addAll(tempList);
                    tempList.clear();
                    for (Shape shape : shapeList) {
                        sketchCanvas.getChildren().add(shape);
                    }
                }
            }
        }
    }

    private class ColorHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // TASK 5: Implement the color handler
            // In this method, the color selected by the user for shape filling and stroke
            // is assigned as color to be used for drawing. This listener is registered with
            // your ComboBoxes. Your ComboBoxes contain Strings that represent colors;
            // however, you cannot use a String as a color to fill a shape. Solution:
            // Determine the index i of the selected color in the fillColorCombo (you can
            // use .getSelectionModel().getSelectedIndex()) and assign the Color that is at
            // index i in the colors[] array to the variable currentFillColor. Do the same
            // for the strokeColorCombo and currentStrokeColor.
            if (event.getSource() == fillColorCombo) {
                currentFillColor = colors[fillColorCombo.getSelectionModel().getSelectedIndex()];
            } else if (event.getSource() == strokeColorCombo) {
                currentStrokeColor = colors[strokeColorCombo.getSelectionModel().getSelectedIndex()];
            } else if (event.getSource() == strokeWidthCombo) {
                currentStrokeWidth = Integer.parseInt(strokeWidthCombo.getSelectionModel().getSelectedItem());
            }
        }
    }

    private class WidthHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // TASK 6: Implement the stroke width handler
            // The WidthHandler class implements the EventHandler interface and must provide
            // an implementation for the following method: public void handle (ActionEvent
            // e)
            // The stroke width selected by the user is parsed as Integer and assigned to
            // the variable currentStrokeWidth.
            currentStrokeWidth = Integer.parseInt(strokeWidthCombo.getSelectionModel().getSelectedItem());
        }
    }
}
