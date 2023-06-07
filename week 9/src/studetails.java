import java.util.Scanner;
abstract class course{
    public abstract void studentDetails();
}
class Comps extends course {
    String UID, name, yearstr;
    public int year;

    Comps(String name, String UID, String year) {
        this.name = name;
        this.UID = UID;
        yearstr = year;
        if (yearstr.equals("FE")) {
            this.year = 1;
        } else if (yearstr.equals("SE")) {
            this.year = 2;
        } else {
            this.year = 3;
        }
    }

    @Override
    public void studentDetails() {
        System.out.println("The name of the student is: " + name);
        System.out.println("His/her UID is: " + UID);
        System.out.println("He/she currently studies in " + yearstr);
    }
}
class IT extends course{
    String UID,name,yearstr;
    public int year;
    IT(String name,String UID,String year){
        this.name=name;
        this.UID=UID;
        yearstr=year;
        if(yearstr.equals("FE")){
            this.year=1;
        }
        else if(yearstr.equals("SE")){
            this.year=2;
        }
        else{
            this.year=3;
        }
    }
    @Override
    public void studentDetails() {
        System.out.println("The name of the student is: "+name);
        System.out.println("His/her UID is: "+UID);
        System.out.println("He/she currently studies in "+yearstr);
    }
}

public class studetails {
    public static void main(String[] args) {
        int nocomps,noit;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Comps and IT students respectively");
        nocomps=sc.nextInt();
        noit=sc.nextInt();
        Comps[] compsarr=new Comps[nocomps];
        IT[] itarr=new IT[noit];
        sc.nextLine();
        String tempname,tempUID,tempyear;
        for(int i=0;i<nocomps;i++){
            System.out.println("Enter the name,UID and year(FE,SE,TE) of comps student "+(i+1));
            tempname= sc.nextLine();
            tempUID=sc.nextLine();
            tempyear=sc.nextLine();
            compsarr[i]=new Comps(tempname,tempUID,tempyear);
        }
        for(int i=0;i<noit;i++){
            System.out.println("Enter the name,UID and year(FE,SE,TE) of IT student "+(i+1));
            tempname= sc.nextLine();
            tempUID=sc.nextLine();
            tempyear=sc.nextLine();
            itarr[i]=new IT(tempname,tempUID,tempyear);
        }
        System.out.printf("Enter course name to print data for: ");
        String course=sc.nextLine();
        if(course.equals("comps")){
            Comps temp;
            for(int i=1;i<nocomps;i++){
                int j=i;
                temp=compsarr[j];
                while(compsarr[j-1].year>temp.year){
                    compsarr[j]=compsarr[j-1];
                    j--;
                    if(j==0){
                        break;
                    }
                }
                compsarr[j]=temp;
            }
            for(int i=0;i<nocomps;i++){
                compsarr[i].studentDetails();
            }
        }
        else{
            IT temp;
            for(int i=1;i<noit;i++){
                int j=i;
                temp=itarr[j];
                while(itarr[j-1].year>temp.year){
                    itarr[j]=itarr[j-1];
                    j--;
                    if(j==0){
                        break;
                    }
                }
                itarr[j]=temp;
            }
            for(int i=0;i<noit;i++){
                itarr[i].studentDetails();
            }
        }

    }
}
