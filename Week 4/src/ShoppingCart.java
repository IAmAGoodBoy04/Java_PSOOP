import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // Create a 3D array to store shopping cart data
        int[][][] cart =new int[3][2][];

        // Ask for input from the user for each cart
        int item_count;
        for(int i=0;i<3;i++){
            System.out.printf("Enter number of perishable items in cart %d: ",i+1);
            item_count=sc.nextInt();

            // Create an array to store perishable item costs
            cart[i][0]=new int[item_count];

            // Ask for input from the user for each perishable item
            System.out.println("Enter cost of these items, one by one (Enter 0 if the item was not sold):");
            for(int x=0;x<item_count;x++){
                cart[i][0][x]=sc.nextInt();
            }

            System.out.printf("Enter number of non-perishable items in cart %d: ",i+1);
            item_count=sc.nextInt();

            // Create a 1D array to store non-perishable item costs
            cart[i][1]=new int[item_count];

            // Ask for input from the user for each non-perishable item
            System.out.println("Enter cost of these items, one by one (Enter 0 if the item was not sold):");
            for(int x=0;x<item_count;x++){
                cart[i][1][x]=sc.nextInt();
            }
        }

        int sum,perishable_sold=0,costliestnp=0;
        for(int i=0;i<3;i++){
            sum=0;

            // Iterate through each item in the cart
            for(int j=0;j<2;j++){
                for(int k=0;k<cart[i][j].length;k++){
                    if(j==0){ // Check if the item is perishable
                        if(cart[i][j][k]!=0) {
                            perishable_sold++;
                        }
                    }
                    sum+=cart[i][j][k];
                    if(j==1){ // Check if the item is non-perishable
                        if(cart[i][j][k]>costliestnp){
                            costliestnp=cart[i][j][k];
                        }
                    }
                }
            }

            // Print the total cost of the cart
            System.out.printf("The total cost of cart %d is %d\n",i+1,sum);
        }

        // Print the number of perishable items sold and the costliest non-perishable item sold
        System.out.println("The number of perishable items sold is: "+perishable_sold);
        System.out.println("The costliest non perishable item sold is: " + costliestnp);
    }
}