import java.util.Scanner;

public class Citytemp {
    public static void main(String[] args) {
        int i,j;
        int days,cities,day;
        float mintemp=1000,maxtemp=-100,tempsearch=-150;
        int mincity=0,maxcity=0,minday=0,maxday=0;
        String city;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of cities");
        cities=sc.nextInt();
        System.out.println("enter number of days to keep record for");
        days=sc.nextInt();
        sc.nextLine();
        String[] citynames =new String[cities];
        float[][] temps=new float[days][cities];
        for(i=0;i<cities;i++){
            System.out.println("Enter name of city");
            citynames[i]=sc.nextLine();
            System.out.println("Enter temperature in the city for the "+days+" days");
            for(j=0;j<days;j++) {
                temps[j][i] = sc.nextFloat();
            }
            sc.nextLine();
        }
        System.out.println("The table of temperatures across those days in the cities are:");
        for(i=0;i<cities;i++){
            System.out.printf("| %15s |",citynames[i]);
        }
        System.out.printf("\n");
        for(j=0;j<days;j++){
            for(i=0;i<cities;i++){
                System.out.printf("| %15.2f |",temps[j][i]);
                if(temps[j][i]<mintemp){
                    mintemp=temps[j][i];
                    mincity=i;
                    minday=j;
                }
                if(temps[j][i]>maxtemp){
                    maxtemp=temps[j][i];
                    maxcity=i;
                    maxday=j;
                }
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        System.out.println("The minimum temperature "+temps[minday][mincity]+" occurs in "+citynames[mincity]+" at day "+(minday+1));
        System.out.println("The maximum temperature "+temps[maxday][maxcity]+" occurs in "+citynames[maxcity]+" at day "+(maxday+1));
        System.out.println("Enter day and city to find temperature:");
        day=sc.nextInt();
        sc.nextLine();
        city=sc.nextLine();
        for(int x=0;x<cities;x++){
            if(citynames[x].equals(city)){
                tempsearch=temps[day][x];
            }
        }
        if(tempsearch!=-150) {
            System.out.printf("The temperature in %s at day %d was %f", city, day, tempsearch);
        }
        else {
            System.out.println("Invalid input");
        }
    }
}