import java.util.Scanner;

public class Citytemp {
    public static void main(String[] args) {
        int i,j;
        int days,cities,day;
        float mintemp=1000,maxtemp=-100,tempsearch=-150;
        int mincity=0,maxcity=0,minday=0,maxday=0;
        String city;
        Scanner sc=new Scanner(System.in); // Creating Scanner object to read input from user
        System.out.println("Enter number of cities");// Prompting user to enter number of cities
        cities=sc.nextInt();
        // Prompting user to enter number of days to keep record for
        System.out.println("enter number of days to keep record for");
        days=sc.nextInt();
        // Consuming newline character left behind by nextInt() method
        sc.nextLine();
        // Initializing arrays to hold city names and temperature data
        String[] citynames =new String[cities];
        float[][] temps=new float[days][cities];
        // Looping through the cities and days to get temperature data for each city
        for(i=0;i<cities;i++){
            // Prompting user to enter the name of the city
            System.out.println("Enter name of city");
            citynames[i]=sc.nextLine();
            // Prompting user to enter temperature data for each day in the city
            System.out.println("Enter temperature in the city for the "+days+" days");
            for(j=0;j<days;j++) {
                temps[j][i] = sc.nextFloat();
            }
            // Consuming newline character left behind by nextFloat() method
            sc.nextLine();
        }
        // Printing the table of temperatures across those days in the cities
        System.out.println("The table of temperatures across those days in the cities are:");
        for(i=0;i<cities;i++){
            System.out.printf("| %15s |",citynames[i]);
        }
        System.out.printf("\n");
        for(j=0;j<days;j++){
            for(i=0;i<cities;i++){
                System.out.printf("| %15.2f |",temps[j][i]);
                if(temps[j][i]<mintemp){// Finding the minimum temperature, city and day
                    mintemp=temps[j][i];
                    mincity=i;
                    minday=j;
                }
                if(temps[j][i]>maxtemp){// Finding the maximum temperature, city and day
                    maxtemp=temps[j][i];
                    maxcity=i;
                    maxday=j;
                }
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        // Printing the minimum and maximum temperature along with the city and day they occur
        System.out.println("The minimum temperature "+temps[minday][mincity]+" occurs in "+citynames[mincity]+" at day "+(minday+1));
        System.out.println("The maximum temperature "+temps[maxday][maxcity]+" occurs in "+citynames[maxcity]+" at day "+(maxday+1));
        // Prompting user to enter day and city to find temperature
        System.out.println("Enter day and city to find temperature:");
        day=sc.nextInt();
        sc.nextLine();
        city=sc.nextLine();
        // Looping through the cities to find the temperature for the given day and city
        for(int x=0;x<cities;x++){
            if(citynames[x].equals(city)){
                tempsearch=temps[day-1][x];
            }
        }
        // Printing the temperature for the given day and city if input is valid
        if(tempsearch!=-150) {
            System.out.printf("The temperature in %s at day %d was %f", city, day, tempsearch);
        }
        else {
            System.out.println("Invalid input");
        }
    }
}