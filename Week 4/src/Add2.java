// Importing the Scanner class from the java.util package
import java.util.Scanner;

// Defining a public class called "Add2"
public class Add2 {

    // Defining a static method called "addtwo" that takes an integer array as an input parameter
    // This method adds 2 to each element of the array and returns the modified array
    static int[] addtwo(int []arr){
        for(int i=0;i<arr.length;i++){
            arr[i]+=2; // Adding 2 to the current element of the array
        }
        return arr; // Returning the modified array
    }

    // Defining the main method
    public static void main(String[] args) {

        // Declaring an integer variable called "n"
        int n;

        // Printing a message to prompt the user to enter the number of elements in the array
        System.out.println("Enter number of elements in array");

        // Creating a new Scanner object called "sc"
        Scanner sc=new Scanner(System.in);

        // Reading an integer value from the user and storing it in the "n" variable
        n=sc.nextInt();

        // Creating a new integer array called "numbers" with "n" elements
        int[] numbers=new int[n];

        // Printing a message to prompt the user to enter the elements of the array
        System.out.println("enter the elements in the array");

        // Looping through each element of the "numbers" array and reading an integer value from the user for each element
        for (int i=0;i<n;i++){
            numbers[i]=sc.nextInt();
        }

        // Creating a new integer array called "newarr" with "n" elements
        int[] newarr=new int[n];

        // Calling the "addtwo" method with the "numbers" array as the input parameter and storing the returned array in "newarr"
        newarr=addtwo(numbers);

        // Printing a message to indicate that the new array is being displayed
        System.out.println("The new array is:");

        // Looping through each element of the "newarr" array and printing it to the console
        for(int i=0;i<n;i++){
            System.out.printf("%d ",newarr[i]);
        }
    }
}