import java.util.*;
//creating an abstract class
abstract class Marks {
    public abstract double getPercentage();
}

class A extends Marks {
    private int m1,m2,m3;
    public A(int m1, int m2, int m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    @Override
    public double getPercentage() {
        return (m1+m2+m3)/3.0;
    }

    //method prints the marks of student A from highest to lowest
    public void displayMarks() {
        int[] m = {m1,m2,m3};
        //sorting the array
        Arrays.sort(m);
        //using collection framework to reverse an array
        Collections.reverse(Arrays.asList(m));
        System.out.println("\nMarks of student A");
        for (int j : m) {
            System.out.printf("%d ", j);
        }
    }
}

class B extends Marks {
    private int m1,m2,m3,m4;

    public B(int m1, int m2, int m3,int m4) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
    }

    @Override
    public double getPercentage() {
        return (m1+m2+m3+m4)/4.0;
    }

    //method prints the marks of student A from highest to lowest
    public void displayMarks() {
        int[] m = {m1,m2,m3,m4};
        Arrays.sort(m);
        Collections.reverse(Arrays.asList(m));
        System.out.println("\nMarks of student B");
        for (int j : m) {
            System.out.printf("%d ", j);
        }
    }
}

public class percentmarks {
    public static void main(String[] args) {
        int[] m = new int[4];
        Scanner sc = new Scanner(System.in);
        //inputting the marks of Student A
        System.out.println("Enter the marks of student A.");
        for(int i=0;i<3;i++) {
            System.out.printf("Subject %d: ",i+1);
            m[i] = sc.nextInt();
        }
        A a = new A(m[0],m[1],m[2]);

        //inputting the marks of Student B
        System.out.println("\nEnter the marks of student B.");
        for(int i=0;i<4;i++) {
            System.out.printf("Subject %d: ",i+1);
            m[i] = sc.nextInt();
        }
        B b = new B(m[0],m[1],m[2],m[3]);

        //printing how much %age they got
        System.out.printf("\nA secured %.2f%c\n",a.getPercentage(),'%');
        System.out.printf("B secured %.2f%c\n",b.getPercentage(),'%');

        //printing their marks in descending order
        a.displayMarks();
        b.displayMarks();
    }
}

