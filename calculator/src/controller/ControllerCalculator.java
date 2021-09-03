package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import session.Session;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCalculator implements Initializable {
    /**
     * This class controls the actions connected to the GUI
     * The goal is to take the user input from the buttons on the GUI
     * and update the label to show the result of the submitted calculation
     */

    //Reference the GUI elements, to make the connection with the controller
    @FXML
    private Label label_display;

    @FXML
    private Button number_seven;

    @FXML
    private Button number_eight;

    @FXML
    private Button number_nine;

    @FXML
    private Button number_four;

    @FXML
    private Button number_five;

    @FXML
    private Button number_six;

    @FXML
    private Button number_one;

    @FXML
    private Button number_two;

    @FXML
    private Button number_three;

    @FXML
    private Button number_zero;

    @FXML
    private Button number_plus;

    @FXML
    private Button number_minus;

    @FXML
    private Button number_multiply;

    @FXML
    private Button number_divide;

    @FXML
    private Button number_parenthesis_open;

    @FXML
    private Button number_parenthesis_close;

    @FXML
    private Button number_equal;

    @FXML
    private Button number_reset;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setting label value to zero as default
        label_display.setText("0");
    }

    //Actions per button pressed - num pad

    //This method sets the values stored in the Session class to execute the operations on
    //Each time a num pad key is pressed, it checks and sets the value in the Session class
    private void setButtonValue(Integer valueOfButton) {
        //Using the operatorHasBeenPressed boolean to control which number is being entered
        if (Session.getSessionInstance().isOperatorHasBeenPressed() != true) {
            //Create an Arraylist in the Singleton instance to hold the numbers; adding the current number from the keypad
            Session.getSessionInstance().getMultiDigitFirstNumber().add(valueOfButton);
            //Need to update the label with the integers in the arraylist; applying a StringBuilder,then looping through the arraylist and adding the items
            StringBuilder sb = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitFirstNumber()) {
                sb.append(i == null ? "" : i.toString());
            }
            label_display.setText(sb.toString());
        } else if (Session.getSessionInstance().isOperatorHasBeenPressed() == true) {
            Session.getSessionInstance().getMultiDigitSecondNumber().add(valueOfButton);
            StringBuilder sb = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitSecondNumber()) {
                sb.append(i == null ? "" : i.toString());
            }
            label_display.setText(sb.toString());
        }
    }

    //Reference and function calls of the GUI number keys

    @FXML
    public void numpad_01_pressed() {
        setButtonValue(1);
    }

    @FXML
    public void numpad_02_pressed() {
        setButtonValue(2);
    }

    @FXML
    public void numpad_03_pressed() {
        setButtonValue(3);
    }

    @FXML
    public void numpad_04_pressed() {
        setButtonValue(4);
    }

    @FXML
    public void numpad_05_pressed() {
        setButtonValue(5);
    }

    @FXML
    public void numpad_06_pressed() {
        setButtonValue(6);
    }

    @FXML
    public void numpad_07_pressed() {
        setButtonValue(7);
    }

    @FXML
    public void numpad_08_pressed() {
        setButtonValue(8);
    }

    @FXML
    public void numpad_09_pressed() {
        setButtonValue(9);
    }

    @FXML
    public void numpad_00_pressed() {
        setButtonValue(0);
    }

    //Actions per button pressed - operators
    //Equal button has to call the operations --> at the time the equal is pressed, that's when both numbers are available and expression calculated
    //sets both arraylists empty at end - if either arraylist is empty then gives error message
    @FXML
    public void buttonEqual() {
        if (Session.getSessionInstance().getMultiDigitFirstNumber().isEmpty() || Session.getSessionInstance().getMultiDigitSecondNumber().isEmpty()) {
            System.out.println("Error - Resetting - One number is missing");
        } else if (Session.getSessionInstance().isAdd()) {
            //Get the items from the arraylist then execute the given function
            //Steps:
            // create string from the arraylist --> use the same StringBuilder, looping through
            // convert the string to int
            // make the calculation
            StringBuilder sb01 = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitFirstNumber()) {
                sb01.append(i == null ? "" : i.toString());
            }
            StringBuilder sb02 = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitSecondNumber()) {
                sb02.append(i == null ? "" : i.toString());
            }
            int result = Integer.parseInt(sb01.toString()) + Integer.parseInt(sb02.toString());
            label_display.setText(String.valueOf(result));
            Session.getSessionInstance().getMultiDigitFirstNumber().clear();
            Session.getSessionInstance().getMultiDigitSecondNumber().clear();
            Session.getSessionInstance().setAdd(false);
            Session.getSessionInstance().setSubtract(false);
            Session.getSessionInstance().setMultiply(false);
            Session.getSessionInstance().setDivide(false);
            Session.getSessionInstance().setOperatorHasBeenPressed(false);


        } else if (Session.getSessionInstance().isSubtract()) {
            StringBuilder sb01 = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitFirstNumber()) {
                sb01.append(i == null ? "" : i.toString());
            }
            StringBuilder sb02 = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitSecondNumber()) {
                sb02.append(i == null ? "" : i.toString());
            }
            int result = Integer.parseInt(sb01.toString()) - Integer.parseInt(sb02.toString());
            label_display.setText(String.valueOf(result));
            Session.getSessionInstance().getMultiDigitFirstNumber().clear();
            Session.getSessionInstance().getMultiDigitSecondNumber().clear();
            Session.getSessionInstance().setAdd(false);
            Session.getSessionInstance().setSubtract(false);
            Session.getSessionInstance().setMultiply(false);
            Session.getSessionInstance().setDivide(false);
            Session.getSessionInstance().setOperatorHasBeenPressed(false);

        } else if (Session.getSessionInstance().isDivide()) {
            StringBuilder sb01 = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitFirstNumber()) {
                sb01.append(i == null ? "" : i.toString());
            }
            StringBuilder sb02 = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitSecondNumber()) {
                sb02.append(i == null ? "" : i.toString());
            }
            if (Integer.parseInt(sb01.toString()) == 0 || Integer.parseInt(sb02.toString()) == 0) {
                buttonReset();
                label_display.setText("No dividing with zero :)");
                return;
            }
            int result = Integer.parseInt(sb01.toString()) / Integer.parseInt(sb02.toString());
            label_display.setText(String.valueOf(result));
            Session.getSessionInstance().getMultiDigitFirstNumber().clear();
            Session.getSessionInstance().getMultiDigitSecondNumber().clear();
            Session.getSessionInstance().setAdd(false);
            Session.getSessionInstance().setSubtract(false);
            Session.getSessionInstance().setMultiply(false);
            Session.getSessionInstance().setDivide(false);
            Session.getSessionInstance().setOperatorHasBeenPressed(false);

        } else if (Session.getSessionInstance().isMultiply()) {
            StringBuilder sb01 = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitFirstNumber()) {
                sb01.append(i == null ? "" : i.toString());
            }
            StringBuilder sb02 = new StringBuilder();
            for (Integer i : Session.getSessionInstance().getMultiDigitSecondNumber()) {
                sb02.append(i == null ? "" : i.toString());
            }
            int result = Integer.parseInt(sb01.toString()) * Integer.parseInt(sb02.toString());
            label_display.setText(String.valueOf(result));
            Session.getSessionInstance().getMultiDigitFirstNumber().clear();
            Session.getSessionInstance().getMultiDigitSecondNumber().clear();
            Session.getSessionInstance().setAdd(false);
            Session.getSessionInstance().setSubtract(false);
            Session.getSessionInstance().setMultiply(false);
            Session.getSessionInstance().setDivide(false);
            Session.getSessionInstance().setOperatorHasBeenPressed(false);
        }
    }

    //When an operator boolean is switched to true, it turns the other operator booleans to false as failsafe
    @FXML
    public void buttonPlus() {
        Session.getSessionInstance().setAdd(true);
        Session.getSessionInstance().setSubtract(false);
        Session.getSessionInstance().setMultiply(false);
        Session.getSessionInstance().setDivide(false);
        Session.getSessionInstance().setOperatorHasBeenPressed(true);
    }

    @FXML
    public void buttonMinus() {
        Session.getSessionInstance().setAdd(false);
        Session.getSessionInstance().setSubtract(true);
        Session.getSessionInstance().setMultiply(false);
        Session.getSessionInstance().setDivide(false);
        Session.getSessionInstance().setOperatorHasBeenPressed(true);
    }

    @FXML
    public void buttonMultiply() {
        Session.getSessionInstance().setAdd(false);
        Session.getSessionInstance().setSubtract(false);
        Session.getSessionInstance().setMultiply(true);
        Session.getSessionInstance().setDivide(false);
        Session.getSessionInstance().setOperatorHasBeenPressed(true);
    }

    @FXML
    public void buttonDivide() {
        Session.getSessionInstance().setAdd(false);
        Session.getSessionInstance().setSubtract(false);
        Session.getSessionInstance().setMultiply(false);
        Session.getSessionInstance().setDivide(true);
        Session.getSessionInstance().setOperatorHasBeenPressed(true);
    }

    @FXML
    public void buttonReset() {
        Session.getSessionInstance().setAdd(false);
        Session.getSessionInstance().setSubtract(false);
        Session.getSessionInstance().setMultiply(false);
        Session.getSessionInstance().setDivide(false);
        Session.getSessionInstance().getMultiDigitFirstNumber().clear();
        Session.getSessionInstance().getMultiDigitSecondNumber().clear();
        Session.getSessionInstance().setOperatorHasBeenPressed(false);
        label_display.setText("0");
    }
}
