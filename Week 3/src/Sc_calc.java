import java.lang.Math;

// Define a class named Test
class Test {
    // Declare instance variables
    double base, ans;
    int power;
    int log_base, argument;

    // Define a constructor that sets all instance variables to 2
    Test() {
        base = power = log_base = argument = 2;
    }

    // Define a method to calculate base raised to the power of power
    void Calculate(double base, int power) {
        ans = Math.pow(base, power);
    }

    // Define a method to calculate the logarithm of argument to the base of log_base
    void Calculate(int log_base, int argument) {
        ans = Math.log(argument) / Math.log(log_base);
    }

    // Define a method to display the value of ans
    void display() {
        System.out.println(ans);
    }
}

// Define a public class named Sc_calc
public class Sc_calc {
    public static void main(String[] args) {
        // Create an instance of the Test class
        Test obj = new Test();

        // Call the Calculate method with a double and an integer argument
        obj.Calculate(2, 4);
        System.out.print("The value of log 4 base 2 is: ");
        // Display the result
        obj.display();

        // Call the Calculate method with a double and an integer argument
        obj.Calculate(2.0, 4);
        System.out.print("The value of 2^4 is: ");
        // Display the result
        obj.display();
    }
}