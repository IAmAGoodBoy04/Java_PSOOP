import java.util.Scanner;
import java.lang.Math;
class Calci {
    float x;
    float y;
    char op;
    double ans;

    Calci(float x, float y, char op ){
        this.x = x;
        this.y = y;
        this.op = op;
        this.Calculate();
    }
    double pow(double base, int index){
        double ans=1;
        for(int i=0;i<index;i++){
            ans=ans*base;
        }
        return ans;
    }
    double calc_ln(double num){

        if(num==1){
            return 0;
        }
        if(num>1){

            return 1;
        }
        num=1-num;
        double val=0;
        for(int i=1;i<70;i++){
            val+=pow(num, i)/i;
        }
        val= -1*val;
        return val;
    }
    double calc_log(double num, double base){
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
        while(num>1){
            powten++;
            num=num/10;
        }
        while(base>1){
            powbase++;
            base=base/10;
        }
        val= (calc_ln(num)+powten*ln10)/(calc_ln(base)+powbase*ln10);
        return val;
    }
    void Calculate(){
        if(op=='+'){
            ans=x+y;
        }
        else if(op=='-'){
            ans=x-y;
        }
        else if(op=='*'){
            ans=x*y;
        }
        else if(op=='/'){
            ans=x/y;
        }
        else if(op=='^'){
            ans=Math.pow(x, y);
        }
        else if(op=='%'){
            ans=x%y;
        }
        else if(op=='l'){
            ans= calc_log(x,y);
            int tempans= (int) Math.round(ans);
            if(tempans-ans>0){
                if(tempans-ans<0.000001){
                    ans=tempans;
                }
                else{
                    if(ans-tempans<0.000001){
                        ans=tempans;
                    }
                }
            }
        }
    }
}

class Calculator {
    public static void main(String[] args) {
        float x,y;
        char op;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Expression");
        x=sc.nextFloat();
        op=sc.next().charAt(0);
        y=sc.nextFloat();
        Calci calc= new Calci(x, y, op);
        System.out.println(calc.ans);
        sc.close();
    }
}