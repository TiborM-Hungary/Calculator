package session;

import java.util.ArrayList;

public class Session {
    /**
     * This a singleton class
     * Meant to hold the current value of the calculation at any time
     * Point is that only one instance of this class exist
     * Whenever we make a change to this instance, it will be the same and only instance all the time
     * We have 2 values to be stored:
     * value of the last button pressed from the num pad
     * value of the calculation so far
     */

    public Session() {
    }

    //Empty constructor
    private static Session sessionInstance;

    //Getter - to get the instance of this class - Singleton
    public static Session getSessionInstance() {
        //Failsafe - if there is no instance of the class at this point, we create it
        if (sessionInstance == null) {
            sessionInstance = new Session();
        }
        return sessionInstance;
    }

    //Need an operatorPressed boolean to know, when to move onto the second number --> false-first number, true-second number is entered

    boolean operatorHasBeenPressed = false;

    public boolean isOperatorHasBeenPressed() {
        return operatorHasBeenPressed;
    }

    public void setOperatorHasBeenPressed(boolean operatorHasBeenPressed) {
        this.operatorHasBeenPressed = operatorHasBeenPressed;
    }

    //Getter - Setter - for booleans to track current operation

    boolean add = false;
    boolean subtract = false;
    boolean multiply = false;
    boolean divide = false;

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isSubtract() {
        return subtract;
    }

    public void setSubtract(boolean subtract) {
        this.subtract = subtract;
    }

    public boolean isMultiply() {
        return multiply;
    }

    public void setMultiply(boolean multiply) {
        this.multiply = multiply;
    }

    public boolean isDivide() {
        return divide;
    }

    public void setDivide(boolean divide) {
        this.divide = divide;
    }

    //Two arraylists to hold the integers entered

    ArrayList<Integer> multiDigitFirstNumber = new ArrayList<>();
    ArrayList<Integer> multiDigitSecondNumber = new ArrayList<>();

    public ArrayList<Integer> getMultiDigitFirstNumber() {
        return multiDigitFirstNumber;
    }

    public ArrayList<Integer> getMultiDigitSecondNumber() {
        return multiDigitSecondNumber;
    }
}
