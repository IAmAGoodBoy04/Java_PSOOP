import java.util.*;

class Movie{
    Scanner sc= new Scanner(System.in);
    String Title;
    int Age_res;
    float Cost;
    Movie(){}
    Movie(String Title){
        this.Title=Title;
    }
    void getData(){
        System.out.println("Enter the cost of the movie");
        Cost=sc.nextFloat();
        System.out.println("Enter the Age restriction of the movie");
        Age_res= sc.nextInt();
    }
}
class User{
    User(){}
    Movie M= new Movie();
    User(Movie m,int age,String name,float bal){
        M=m;
        this.age=age;
        this.name=name;
        acc_balance=bal;
    }
    int age;
    String name;
    float acc_balance;
    boolean Can_Watch = age>=M.Age_res;
    void can_watch_movie(){
        if(Can_Watch){
            System.out.println("You can watch this movie");
        }
        else{
            System.out.println("You cannot watch this movie");
        }
    }
    void Watch(){
        acc_balance-= M.Cost;
    }
}
public class Movie_watch {

    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        String Temp_Mov_name;
        String Temp_Mov_name_user;

        System.out.println("Type 0 to exit the admin interface(or anything else to remain in it)");
        int no_of_movies=1;
        while(sc.nextInt()!=0){
            System.out.println("Enter name of movie");
            Temp_Mov_name= sc.next();
            Movie[] Moviearr= new Movie[no_of_movies];
            Moviearr[no_of_movies-1]= new Movie(Temp_Mov_name);
            Moviearr[no_of_movies-1].getData();
        }
        System.out.println("Enter name of movie");
        Temp_Mov_name_user=sc.next();

    }
}
