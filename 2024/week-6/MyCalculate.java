/*
Exercise #6.1
 */
public class MyCalculate {
    // instance variables
    private final int m;
    private final int n;

    // #6.1 constructor for MyCalculate
    public MyCalculate(int n, int m) {
        this.n = n;
        this.m = m;
    }

    // #6.2 override toString method
    @Override
    public String toString() {
        return n + " " + m;
    }

    // #6.3 method to calculate the sum of two numbers
    public int sum() {
        return n + m;
    }

    // #6.4 method to judge if n and m are either greater than 0 or less than 0
    public boolean judge() {
        return (n > 0 && m > 0) || (n < 0 && m < 0);
    }

    // testing
    public static void main(String[] args) {
        MyCalculate example = new MyCalculate(3, 4);
        System.out.println(example);
        System.out.println(example.sum());
        System.out.println(example.judge());
    }
}
