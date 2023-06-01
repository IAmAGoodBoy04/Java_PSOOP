import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class bank{
    float rate_of_interest;
    float amount_in_bank;
    int no_of_days;

    public void setRate_of_interest(float rate_of_interest) {
        this.rate_of_interest = rate_of_interest;
    }

    public float getRate_of_interest() {
        return 2;
    }

    public float getAmount_in_bank() {
        return amount_in_bank;
    }
    public float get_total_amount(){
        return (float) ((float)amount_in_bank*Math.pow((1+rate_of_interest/100),((double) no_of_days /365)));
    }
}
class SBI_bank extends bank{
    SBI_bank(int days,float amount){
        amount_in_bank=amount;
        no_of_days=days;
        set_rate_SBI();
    }
    void set_rate_SBI(){
        if(no_of_days>=7 && no_of_days<=14){
            rate_of_interest= 3.0F;
        }
        else if (no_of_days>14 && no_of_days<=30) {
            rate_of_interest=3.0F;
        }
        else if (no_of_days>30 && no_of_days<=45) {
            rate_of_interest=3.0F;
        }
        else if(no_of_days>45 && no_of_days<=90){
            rate_of_interest=4.05F;
        }
        else if(no_of_days>90 && no_of_days<=120){
            rate_of_interest=4.1F;
        }
        else{
            rate_of_interest=4.1F;
        }
    }

}
class Axis_bank extends bank{
    Axis_bank(int days,float amount){
        amount_in_bank=amount;
        no_of_days=days;
        set_rate_Axis();
    }
    void set_rate_Axis(){
        if(no_of_days>=7 && no_of_days<=14){
            rate_of_interest= 3.15F;
        }
        else if (no_of_days>14 && no_of_days<=30) {
            rate_of_interest=3.15F;
        }
        else if (no_of_days>30 && no_of_days<=45) {
            rate_of_interest=3.45F;
        }
        else if(no_of_days>45 && no_of_days<=90){
            rate_of_interest=4.05F;
        }
        else if(no_of_days>90 && no_of_days<=120){
            rate_of_interest=4.7F;
        }
        else{
            rate_of_interest=5F;
        }
    }
}
class ICICI_bank extends bank{
    ICICI_bank(int days,float amount){
        amount_in_bank=amount;
        no_of_days=days;
        set_rate_ICICI();
    }
    void set_rate_ICICI(){
        if(no_of_days>=7 && no_of_days<=14){
            rate_of_interest= 3.1F;
        }
        else if (no_of_days>14 && no_of_days<=30) {
            rate_of_interest=3.2F;
        }
        else if (no_of_days>30 && no_of_days<=45) {
            rate_of_interest=3.5F;
        }
        else if(no_of_days>45 && no_of_days<=90){
            rate_of_interest=4.5F;
        }
        else if(no_of_days>90 && no_of_days<=120){
            rate_of_interest=4.7F;
        }
        else{
            rate_of_interest=4.9F;
        }
    }
}
public class Bank_interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //assigning today's date to d1
        LocalDate d1 = LocalDate.now();

        //asking the user the amount he has deposited in different banks
        System.out.println("Enter the amount you have deposited in");
        System.out.print("SBI Bank: ");
        int sbi = sc.nextInt();
        System.out.print("ICICI Bank: ");
        int icici = sc.nextInt();
        System.out.print("AXIS Bank: ");
        int axis = sc.nextInt();

        //asking the user when does he want to end his maturity
        System.out.println("Enter the date of maturity.");
        System.out.print("Year: ");
        int year = sc.nextInt();
        System.out.print("Month: ");
        int month = sc.nextInt();
        System.out.print("Day: ");
        int day = sc.nextInt();
        //assigning the date of maturity to d2
        LocalDate d2 = LocalDate.of(year,month,day);

        //calculating the gap between d1 and d2 in terms of years, months and days
        Period gap = Period.between(d1,d2);
        //converting duration into days
        int duration = gap.getYears()*365+gap.getMonths()*30+gap.getDays();
        System.out.print("\nStart date: " + d1 + "\nEnd date: " + d2);
        System.out.printf("\nThe duration for which amount is kept in the bank is %d days.\n",duration);
        SBI_bank sbibank =new SBI_bank(duration,sbi);
        Axis_bank axisBank=new Axis_bank(duration,axis);
        ICICI_bank iciciBank=new ICICI_bank(duration,icici);
        System.out.printf("The amount received after maturity from SBI is %.2f\nThe amount received from Axis bank is %.2f\n" +
                "The amount received from ICICI bank after maturity is %.2f\n",sbibank.get_total_amount(),axisBank.get_total_amount(),iciciBank.get_total_amount());
    }
}
