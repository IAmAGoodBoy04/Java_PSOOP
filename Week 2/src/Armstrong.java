import java.util.*; //Importing util and math class for scanner class and pow function
 import java.lang.Math;
 public class Armstrong{
     public static class Primes{//We declared it as static class as we do not have multiple instances of the parent
         // class and thus it would be easier to create objects this way.
         int start,end,primecount;
         Primes() {}//default constructor
         Primes(int a, int b) {//Parametrised constructor
            start = a;
            end = b;
            primecount=0;
         }
         void displayPrimes(){
            int is_prime;
            if(start==1){
                start++;//Exception for 1 as it's not a prime but satisfies the conditions
            }
            System.out.println("\nThe prime numbers in the given range are:");
            for(int i=start;i<=end;i++) {//Loop for checking whether a number is prime
                is_prime = 1;
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        is_prime = 0;
                        break; }
                } if (is_prime == 1) {
                    primecount++;
                    System.out.printf("%d ", i);//If that number is prime, print it
                    if(primecount%10==0){//To print only 10 prime numbers in a single line
                        System.out.printf("\n");
                    }
                }
            }
            System.out.println("\nThe number of primes in this range are "+primecount);
         }
     }
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);//creating scanner object to read from stream system.in i.e. user i/p
         System.out.print("Enter range\n");
         int range= sc.nextInt();
         int range2= sc.nextInt();
         System.out.println("The Armstrong numbers in the given range are:");
         for(int j=range;j<=range2;j++){//checking for all numbers in the range
             int arms=0,digits=0,temp,n_out;
             int n=j;
             n_out=n;//storing a copy of n(the original number) for later, as n is changed in the subsequent steps
             temp=n;
             do {
                 digits++;
                 temp = temp / 10;
             } while (temp >= 1);//counting number of digits in each number
             for(int i=0;i<digits;i++){
                 temp=n%10;
                 arms=arms+(int)Math.pow(temp,digits);
                 n=n/10;
             }//calculating the sum of individual digits^total number of digits
             if(arms==n_out){
                 System.out.printf("%d ",n_out);
             }
         }
         Primes obj=new Primes(range,range2);//creating object of class Primes nested in class Armstrong
         // As Primes is a static class, we can create an object without mentioning the parent class
         obj.displayPrimes();//calling class method
         }
 }