import java.lang.Math;
    class Test{
        double base,ans;
        int power;
        int log_base,argument;
        Test(){
            base=power=log_base=argument=2;
        }
        void Calculate(double base, int power){
            ans=Math.pow(base,power);
        }
        void Calculate(int log_base, int argument){
            ans=Math.log(argument)/Math.log(log_base);
        }
        void display(){
            System.out.println(ans);
        }
    }
public class Sc_calc {
    public static void main(String[] args) {
        Test obj=new Test();
        obj.Calculate(2,4);
        obj.display();
        obj.Calculate(2.0,4);
        obj.display();
    }
}
