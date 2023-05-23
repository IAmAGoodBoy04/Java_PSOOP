import java.util.Scanner;

public class trimstr{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s=sc.nextLine();
        int m,n;
        System.out.println("Enter number of chracters in extracted string:");
        m=sc.nextInt();
        System.out.println("Enter the position of starting character in extracted string:");
        n=sc.nextInt();
        String newstr=new String();
        for(int i=0;i<m;i++){
            newstr=newstr+s.charAt(i+n-1);
        }
        System.out.println("The trimmed string is: "+newstr);
    }
}