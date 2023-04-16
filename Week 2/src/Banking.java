import java.util.*;

class Bank_acc{
    Scanner sc=new Scanner(System.in);
    double Balance,ROI,interest;
    int months;
    Bank_acc(double initial_Balance, double ROI){//Parametrized constructor for initialising
        // values of initial balance and rate of interest
        Balance=initial_Balance;
        this.ROI=ROI;
    }
    void deposit(double deposited){
        Balance+=deposited;
    }//Method to add deposited amount to balance
    void Withdrawal(double withdrawn){//Method to deduct deposited amount from balance
        if(withdrawn<=Balance){
        Balance-=withdrawn;
        }
        else{
            System.out.println("Balance insufficient for withdrawal");
        }
    }
    void interest(){
        System.out.println("Enter time period in months for interest calculations");
        months=sc.nextInt();
        interest=Balance*Math.pow(1+ROI/100,months)-Balance;
        System.out.println("The interest accrued in "+months+" months is "+interest+" rupees");
    }//Method for printing compound interest(assuming monthly interest)
    void Printbal(){
        System.out.println("The current balance in our account is "+Balance+" rupees");
    }
    void Menu(){
        System.out.println("Select what action to perform by entering the corresponding integer");
        System.out.print("1.Check current balance\n2.Deposit\n3.Withdraw\n4.Calculate compound interest\n");
        switch (sc.nextInt()) {//Enhanced switch statement, cases defined using -> operator
            // do not require a break statement
            case 1 -> Printbal();
            case 2 -> {
                System.out.println("Enter amount to be deposited");
                deposit(sc.nextDouble());
                System.out.println("Amount deposited");
            }
            case 3 -> {
                System.out.println("Enter amount to be withdrawn");
                Withdrawal(sc.nextDouble());
                System.out.println("Amount withdrawn");
            }
            case 4 -> interest();
            default -> System.out.println("Invalid input");
        }
    }
}
public class Banking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double bal,roi;
        System.out.println("Enter initial balance in account and monthly rate of interest(in %)");
        bal=sc.nextDouble();
        roi=sc.nextDouble();
        Bank_acc account=new Bank_acc(bal,roi);
        do{//Driver code
            account.Menu();
            System.out.println("Enter 0 to exit interface, 1 to continue");
        }while(sc.nextInt()!=0);
    }
}