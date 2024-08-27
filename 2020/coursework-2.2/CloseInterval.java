/*
 * CW2.2 Lab-Group-01
 */

// The CloseInterval class represents a one-dimensional interval [low, high],
//     that contains both endpoints low and high.
public class CloseInterval {

    // Do not modify or add the instance variables
    private double low;
    private double high;

    // Do not modify this constructor
    // It initializes the two instance variables
    public CloseInterval(double low, double high) {
        this.low = low;
        this.high = high;
    }

    // Do not modify this method
    // It returns the string representation of a CloseInterval object
    // in the format "[low, high]"
    @Override
    public String toString() {
        return "[" + low + ", " + high + "]";
    }


    // CW2.2 Lab-Group-01 Question 1
    // Complete the method contains
    // It returns true iff the number x is in the close-interval
    public boolean contains(double x) {
        return (low <= x && high >= x);
    }


    // CW2.2 Lab-Group-01 Question 2
    // Complete the method intersects
    // Returns true if this close-interval intersects the other close-interval
    public boolean intersects(CloseInterval other) {
        return (this.high >= other.low && this.low <= other.high);
    }


    // Test Client
    public static void main(String[] args) {

        CloseInterval interval1 = new CloseInterval(2.0, 5.0);
        System.out.println(interval1);               // [2.0, 5.0]

        System.out.println(interval1.contains(3.0));   // true
        System.out.println(interval1.contains(10.0));  // false

        CloseInterval interval2 = new CloseInterval(3.0, 6.0);
        System.out.println(interval1.intersects(interval2));      // true
        CloseInterval interval3 = new CloseInterval(10.0, 11.5);
        System.out.println(interval1.intersects(interval3));      // false

    }
}
