package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import session.Session;

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
    //Plain and simple, we store the value of the num pad key
    private void setButtonValue(Integer valueOfButton) {
        label_display.setText(String.valueOf(valueOfButton));
        if (Session.getSessionValue().getFirstNumber() == null) {
            Session.getSessionValue().setFirstNumber(valueOfButton);
            label_display.setText(String.valueOf(valueOfButton));
        } else if (Session.getSessionValue().getSecondNumber() == null) {
            Session.getSessionValue().setSecondNumber(valueOfButton);
        } else if (Session.getSessionValue().getFirstNumber() != null && Session.getSessionValue().getSecondNumber() != null) {
            Session.getSessionValue().setFirstNumber(valueOfButton);
            label_display.setText(String.valueOf(valueOfButton));
            Session.getSessionValue().setSecondNumber(null);
        }
    }

    @FXML
    public void numpad_01_pressed(){
        setButtonValue(1);
    }
    @FXML
    public void numpad_02_pressed(){
        setButtonValue(2);
    }
    @FXML
    public void numpad_03_pressed(){
        setButtonValue(3);
    }
    @FXML
    public void numpad_04_pressed(){
        setButtonValue(4);
    }
    @FXML
    public void numpad_05_pressed(){
        setButtonValue(5);
    }
    @FXML
    public void numpad_06_pressed(){
        setButtonValue(6);
    }
    @FXML
    public void numpad_07_pressed(){
        setButtonValue(7);
    }
    @FXML
    public void numpad_08_pressed(){
        setButtonValue(8);
    }
    @FXML
    public void numpad_09_pressed(){
        setButtonValue(9);
    }
    @FXML
    public void numpad_00_pressed(){
        setButtonValue(0);
    }

    //Actions per button pressed - operators

    @FXML
    public void buttonPlus(){

    }
}
