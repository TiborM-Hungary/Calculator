package session;

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
    private static Session sessionValue;

    //Getter - to get the the instance of this class - Singleton
    public static Session getSessionValue() {
        //Failsafe - if there is no instance of the class at this point, we create it
        if (sessionValue == null) {
            sessionValue = new Session();
        }
        return sessionValue;
    }

    //Getter - Setter - for the integer in the Singleton class, that holds the value of the calculation for us
    //The Integer is private, only accessible via the getter and setter
    private Integer currentValue;

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    //Getter - Setter - for the 1st number in the Singleton class, that holds the value of the last button pressed for us
    private Integer firstNumber;

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    //Getter - Setter - for the 2nd number in the Singleton class, that holds the value of the last button pressed for us
    private Integer secondNumber;

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }

    //Getter - Setter - for booleans to track current operation

    boolean add = false;
    boolean subtract = false;
    boolean multiply = false;
    boolean divide = false;

    //boolean for tracking parenthesis probably not the best idea
    boolean parenthesisOpen = false;
    boolean parenthesisClosed = false;

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
}
