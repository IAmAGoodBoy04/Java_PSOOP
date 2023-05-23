import java.util.Arrays;
import java.util.Scanner;

public class Stringhandling{
    public static void main(String[] args) {
        System.out.println("Enter a string:");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int temp,j;
        int[] strarr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            strarr[i]=(int)s.charAt(i);
        }
        for(int i=1;i<s.length();i++){
            temp=strarr[i];
            j=i;
            while(strarr[j-1]>temp){
                strarr[j]=strarr[j-1];
                j--;
                if(j==0){
                    break;
                }
            }
            strarr[j]=temp;
        }
        String snew=new String();
        char string_buffer;
        for(int i=0;i<s.length();i++){
            string_buffer=(char)strarr[i];
            snew=snew+string_buffer;
        }
        System.out.println("The string sorted in alphabetical order is: "+snew);
        sc.close();
    }
}