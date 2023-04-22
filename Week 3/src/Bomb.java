// import necessary classes
import java.util.Date;
import java.util.Scanner;

// define a public class named Bomb
public class Bomb {
    public static void main(String[] args) {
        // declare and initialize variables to store the explosion date
        int exp_day, exp_month, exp_year;

        // prompt the user to enter the explosion date
        System.out.println("Enter Date of explosion (as day, month and year, seperated by spaces/newlines)");

        // create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // read the input values for the explosion date from the user and store them in the variables
        exp_day = sc.nextInt();
        exp_month = sc.nextInt();
        exp_year = sc.nextInt();

        // create a new Date object to represent the current date and time
        Date current = new Date();

        // create a new Date object to represent the explosion date, adjusting the year and month to account for the
        // Date class's quirks
        Date explosion = new Date(exp_year - 1900, exp_month - 1, exp_day);

        // calculate the number of milliseconds between the current date and time and the explosion date and time
        long current_time = current.getTime();
        long exp_time = explosion.getTime();
        long ms_between_dates = exp_time - current_time;

        // calculate the number of milliseconds in a day and use it to calculate the number of days between the
        // current date and time and the explosion date and time
        long ms_in_a_day = 1000 * 60 * 60 * 24;
        long days_between_dates = ms_between_dates / ms_in_a_day + 1;

        // output the number of days until the explosion to the user
        System.out.println("The number of days till the explosion is: " + days_between_dates);
    }
}