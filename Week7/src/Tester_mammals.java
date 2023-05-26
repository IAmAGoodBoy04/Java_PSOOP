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
    String colour;
    float weight;

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

    static float sumWt=0;
    static int lab_count=0;

    public static int getLab_count() {
        return lab_count;
    }

    public String speak() { return "WOOF"; }
    public static float calculateAvgWeight(){
        return sumWt/lab_count;
    }
}
class germanSheperd extends Dog{
    float height;
    int lifespan;
    static float sumHt=0;
    public static int shep_count=0;

    public static int getShep_count() {
        return shep_count;
    }

    public String speak() { return "GRUNT"; }
    public static float calculateAvgHeight(){
        return sumHt/shep_count;
    }
}

public class Tester_mammals {
    public static String popularBreed(){
        if(Labrador.lab_count>germanSheperd.shep_count){
            return "Labrador";
        }
        else{
            return "German Sheperd";
        }
    }

    public static void main(String[] args) {

    }
}