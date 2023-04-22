import java.util.Scanner;
import java.lang.Math;

// Calci class to perform arithmetic and logarithmic calculations
class Calci {
    float x; // first operand
    float y; // second operand
    char op; // operator(+,-,/,*,^,log,%)
    double ans; // result of calculation

    // constructor to initialize operands, operator and perform calculation
    Calci(float x, float y, char op ){
        this.x = x;
        this.y = y;
        this.op = op;
        this.Calculate(); // perform calculation
    }
    // method to calculate the power of a number
    double pow(double base, int index){
        double ans=1;
        for(int i=0;i<index;i++){//The loop multiplies base index number of times
            ans=ans*base;
        }
        return ans;
    }
    double calc_ln(double num){/*
         This method calculates the natural logarithm of a number using the Taylor series
         expansion of the logarithm function. The loop iterates 75 times(precision depends on number of times the
         loop is iterated), adding the i-th term of the series to val,which is then multiplied by -1 to get the natural
         logarithm of the number.
        */
        if(num==1){
            return 0;
        }
        if(num>1){

            return 1;
        }

        num=1-num;
        double val=0;
        for(int i=1;i<75;i++){
            val+=pow(num, i)/i;
        }
        val= -1*val;
        return val;
    }
    double calc_log(double num, double base){/*
         calculates the logarithm of a number with a given base by dividing the
         natural logarithm of the number by the natural logarithm of the base. It first converts the number and base
         to a number between 1 and 0, then calculates the natural logarithms of the number and
         base, and finally uses those to calculate the logarithm.
        */
        if(num==1){
            return 0;
        }
        if(num<=0 || base<=0){
            return 0;
        }

        double val;
        final double ln10=2.302585092994045684018;
        int powten=0;
        int powbase=0;

        // convert number and base to a number between 1 and 0
        while(num>1){
            powten++;
            num=num/10;
        }
        while(base>1){
            powbase++;
            base=base/10;
        }

        // calculate logarithm
        val= (calc_ln(num)+powten*ln10)/(calc_ln(base)+powbase*ln10);
        return val;
    }
    void Calculate(){// method to perform the calculation based on the operator
        switch (op) {
            case '+' -> ans = x + y;
            case '-' -> ans = x - y;
            case '*' -> ans = x * y;
            case '/' -> ans = x / y;
            case '^' -> ans = Math.pow(x, y);
            case '%' -> ans = x % y;
            case 'l' -> {
                ans = calc_log(x, y);
                int tempans = (int) Math.round(ans);
                // round off answer to 6 decimal places
                if (tempans - ans > 0) {
                    if (tempans - ans < 0.000001) {
                        ans = tempans;
                    }
                }
                else {
                    if (ans - tempans < 0.000001) {
                        ans = tempans;
                    }
                }
            }
        }
    }
}
// Calculator class to get user input and print result
class Calculator {
    public static void main(String[] args) {
        float x, y;
        char op;
        Scanner sc = new Scanner(System.in);
        // prompt user to enter an expression in the format x op y
        System.out.println("Enter an Expression");
        x = sc.nextFloat();
        op = sc.next().charAt(0);
        y = sc.nextFloat();

        // create a new Calci object and print result of calculation
        Calci calc = new Calci(x, y, op);
        System.out.println("The answer is: "+calc.ans);
        sc.close();
    }
}