import java.util.Scanner;
abstract class Shape{
    abstract double RectangleArea(double a , double b);
    abstract double SquareArea(double x);
    abstract double CircleArea(double r);

}
class Area extends Shape{
    int a,b;
    public double RectangleArea(double a , double b){
        return a*b ;
    }
    public double SquareArea(double x){
        return x*x;
    }
    public double CircleArea(double r){
        return 3.142*r*r;
    }
}
public class shapeArea{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Area A = new Area();
        for(int i=4;i>0;i--){
            System.out.print("Enter the Sides of Rectangle\n");
            int  x = sc.nextInt();
            int  y = sc.nextInt();
            System.out.println();
            System.out.println("Area of Rectangle is : \n" + A.RectangleArea(x,y));
            System.out.println();
        }
        for(int i=5;i>0;i--){
            System.out.print("Enter the Side Of Square \n");
            int  c = sc.nextInt();
            System.out.println();
            System.out.println("Area of Square is : \n" + A.SquareArea(c));
        }
        for(int i=2;i>0;i--){
            System.out.print("Enter the Radius of Circle \n");
            int  d = sc.nextInt();
            System.out.println();
            System.out.println("Area of Circlee is : \n" + A.CircleArea(d));
        }
    }
}