import java.util.Scanner;

class Mammals{
    boolean is_bird;

    public int getNo_of_legs() {
        return no_of_legs;
    }

    public boolean isIs_bird() {
        return is_bird;
    }

    public void setNo_of_legs(int no_of_legs) {
        this.no_of_legs = no_of_legs;
    }

    public void setIs_bird(boolean is_bird) {
        this.is_bird = is_bird;
    }
    int no_of_legs;
}
class Dog extends Mammals{
    public Dog(String name, int age){
        is_bird=false;
        no_of_legs=4;
        this.name=name;
        this.age=age;
    }
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Labrador extends Dog{
    public Labrador(String name, int age, String colour, float weight){
        super(name, age);
        this.colour=colour;
        this.weight=weight;
        sumlabage+=age;
        sumWt+=weight;
        lab_count++;
    }
    String colour;
    float weight;
    public static int sumlabage=0;
    public String getColour() {
        return colour;
    }

    public float getWeight() {
        return weight;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public static float sumWt=0;
    static int lab_count=0;

    public static int getLab_count() {
        return lab_count;
    }
    public static float avglabLifeExpectancy(){
        return (float) sumlabage /lab_count;
    }

    public String speak() { return "WOOF"; }
    public static float calculateAvgWeight(){
        return sumWt/lab_count;
    }
}
class germanSheperd extends Dog{
    public germanSheperd(String name, int age, float height, int lifespan){
        super(name, age);
        this.height=height;
        this.lifespan=lifespan;
        sumHt+=height;
        sumshepage+=age;
        shep_count++;
    }
    float height;
    int lifespan;
    public static float sumHt=0;
    public static int shep_count=0;
    public static int sumshepage=0;
    public static float avgshepLifeExpectancy(){
        return (float) sumshepage /shep_count;
    }

    public static int getShep_count() {
        return shep_count;
    }

    public String speak() { return "GRUNT"; }
    public static float calculateAvgHeight(){
        return sumHt/shep_count;
    }
}

public class Tester_mammals {
    public static float avgLifeExpectancy(String breed){
        if(breed.equals("Labrador")){
            return Labrador.avglabLifeExpectancy();
        }
        else{
            return germanSheperd.avgshepLifeExpectancy();
        }
    }
    public static String popularBreed(){
        if(Labrador.lab_count>germanSheperd.shep_count){
            return "Labrador";
        }
        else if (Labrador.lab_count==germanSheperd.shep_count){
            return "Both breeds are equally popular";
        }
        else{
            return "German Sheperd";
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter total number of labradors and german sheperds:");
        int nolab=sc.nextInt();
        int noshep=sc.nextInt();
        Labrador[] Lab_arr=new Labrador[nolab];
        germanSheperd[] shep_arr=new germanSheperd[noshep];
        String tempname,tempcolor;
        int tempage,templifespan;
        float tempweight,tempheight;

        for(int i=0;i<nolab;i++){
            sc.nextLine();
            System.out.println("Enter name, age, color and weight(in Kg) of Labrador "+(1+i));
            tempname=sc.nextLine();
            tempage=sc.nextInt();
            sc.nextLine();
            tempcolor=sc.nextLine();
            tempweight=sc.nextFloat();
            Lab_arr[i]=new Labrador(tempname,tempage,tempcolor,tempweight);
        }
        for(int i=0;i<noshep;i++){
            sc.nextLine();
            System.out.println("Enter name, age, height(in cm) and lifespan of german sheperd "+(i+1));
            tempname=sc.nextLine();
            tempage=sc.nextInt();
            sc.nextLine();
            tempheight=sc.nextFloat();
            templifespan=sc.nextInt();
            shep_arr[i]=new germanSheperd(tempname,tempage,tempheight,templifespan);
        }
        System.out.println("The most popular breed is: "+popularBreed());
        System.out.println("The life expectancy of labradors and german sheperds respctively is: ");
        System.out.println(avgLifeExpectancy("Labrador")+" and "+avgLifeExpectancy("German Sheperd"));
        System.out.println("The average weight of Labradors if: "+Labrador.calculateAvgWeight());
        System.out.println("The average height of german sheperds is: "+germanSheperd.calculateAvgHeight());

    }
}