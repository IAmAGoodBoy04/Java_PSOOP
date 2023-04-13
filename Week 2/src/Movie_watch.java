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
        if(Can_Watch && acc_balance>=M.Cost) {
            acc_balance -= M.Cost;
        }
        else{
            System.out.println("You cannot watch this movie or balance is insufficient");
        }
    }
    void printbal(){
        System.out.println("The updated balance is: "+ acc_balance);
    }
}
public class Movie_watch {
    public static void main(String[] args) {
        int usr_age;
        String usr_name;
        float usr_bal;
        Scanner sc= new Scanner (System.in);
        String Temp_Mov_name;
        String Temp_Mov_name_user;
        ArrayList<Movie>Moviearr = new ArrayList<Movie>();
        System.out.println("Type the name, age and initial account balance of user");
        usr_name=sc.nextLine();
        usr_age=sc.nextInt();
        usr_bal=sc.nextFloat();
        System.out.println("Type 0 to exit the admin interface(or 1 to remain in it)");
        while(sc.nextInt()!=0){
            sc.nextLine();//To clear input buffer
            System.out.println("Enter name of movie");
            Temp_Mov_name= sc.nextLine();
            Temp_Mov_name=Temp_Mov_name.toLowerCase();
            Movie Tempmov= new Movie(Temp_Mov_name);
            Tempmov.getData();
            Moviearr.add(Tempmov);
            System.out.println("Type 0 to exit the admin interface(or 1 to remain in it)");
        }
        System.out.println("You are now in User interface, press 0 to exit it, 1 to remain");
        while(sc.nextInt()!=0) {
            sc.nextLine();//To clear \n from buffer
            int req_index=-1;
            System.out.println("Enter name of movie");
            Temp_Mov_name_user = sc.nextLine();
            Temp_Mov_name_user=Temp_Mov_name_user.toLowerCase();
            for(int i=0;i<Moviearr.size();i++){
                if(Moviearr.get(i).Title.equals(Temp_Mov_name_user)){
                    req_index=i;
                    break;
                }
            }
            if(req_index==-1){
                System.out.println("Movie not found");
            }
            else{
                User usr=new User(Moviearr.get(req_index),usr_age,usr_name,usr_bal);
                usr.can_watch_movie();
                System.out.println("Do you want to watch this movie? (enter 1 for yes, 0 for no)");
                if(sc.nextInt()==1){
                    usr.Watch();
                    usr.printbal();
                }
            }
            System.out.println("Enter 0 to exit program, 1 to check for another movie");
        }
    }
}
