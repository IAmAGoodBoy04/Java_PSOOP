import java.util.Scanner;

class shapes{
    float radius,length,breadth;
    float Area,perimeter;
    shapes(float r){
        radius=r;
        Area=Area(radius);
        perimeter=perimeter(radius);
    }
    shapes(float l, float b){
        length=l;
        breadth=b;
        Area=Area(length,breadth);
        perimeter=perimeter(length,breadth);
    }
    float Area(float r){
        return (float) (3.14*r*r);
    }
    float Area(float l, float b){
        return l*b;
    }
    float perimeter(float r){
        return (float) (2*3.14*r);
    }
    float perimeter(float l, float b){
        return 2*(l+b);
    }

}
public class constructors {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        float r,l,b;
        System.out.println("Enter radius of circle and length and breadth of rectangle");
        r=sc.nextFloat();
        l=sc.nextFloat();
        b=sc.nextFloat();
        shapes circle=new shapes(r);
        shapes rectangle=new shapes(l,b);
        System.out.println("The area and circumference of the circle are:");
        System.out.printf("%f and %f\n",circle.Area,circle.perimeter);
        System.out.println("The ara and perimeter of the rectangle are:");
        System.out.printf("%f and %f\n",rectangle.Area,rectangle.perimeter);
    }
}
