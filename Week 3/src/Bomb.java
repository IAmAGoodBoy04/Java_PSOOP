import java.util.Date;
import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        int exp_day,exp_month,exp_year;
        System.out.println("Enter Date of explosion (as day, month and year, seperated by spaces/newlines");
        Scanner sc=new Scanner(System.in);
        exp_day=sc.nextInt();
        exp_month=sc.nextInt();
        exp_year=sc.nextInt();
        Date current=new Date();
        Date explosion=new Date(exp_year-1900,exp_month-1,exp_day);
        long current_time= current.getTime();
        long exp_time= explosion.getTime();
        long ms_betn_dates=exp_time-current_time;
        long ms_in_a_day=1000*60*60*24;
        long days_betn_dates=ms_betn_dates/ms_in_a_day+1;
        System.out.println("The number of days till the explosion is: "+days_betn_dates);
    }
}