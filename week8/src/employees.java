import java.util.Scanner;

class Employee {
    float salary, bonus;

    public Employee() {
        salary = 10000;
        bonus = 0;
    }

    public void setBaseSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary + salary * bonus / 100;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

}

class Intern extends Employee {
    float internbonus;

    Intern() {
        internbonus = 0;
    }

    @Override
    public float getSalary() {
        return 3 * (salary + salary * internbonus / 100) / 4;
    }

    @Override
    public void setBonus(float bonus) {
        internbonus = bonus;
    }
    @Override
    public float getBonus() {
        return internbonus;
    }
}

class Clerk extends Employee {
    float Clerkbonus;

    Clerk() {
        Clerkbonus = 0;
    }

    @Override
    public float getSalary() {
        return (salary + salary * Clerkbonus / 100) / 2;
    }

    @Override
    public void setBonus(float bonus) {
        Clerkbonus = bonus;
    }
    @Override
    public float getBonus() {
        return Clerkbonus;
    }
}

class Manager extends Employee {
    float Managerbonus;

    Manager() {
        Managerbonus = 0;
    }

    @Override
    public float getSalary() {
        return 2 * (salary + salary * Managerbonus / 100);
    }

    @Override
    public void setBonus(float bonus) {
        Managerbonus = bonus;
    }
    @Override
    public float getBonus() {
        return Managerbonus;
    }
}

public class employees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Intern intern1 = new Intern();
        Clerk clerk1 = new Clerk();
        Manager manager1 = new Manager();
        System.out.println("Enter values of bonus for Intern, clerk and manager respectively:");
        intern1.setBonus(sc.nextFloat());
        clerk1.setBonus(sc.nextFloat());
        manager1.setBonus(sc.nextFloat());
        System.out.printf("The salary of Intern is: %.2f (with %.2f%% bonus)\n",intern1.getSalary(),intern1.getBonus());
        System.out.printf("The salary of Clerk is: %.2f (with %.2f%% bonus)\n",clerk1.getSalary(),clerk1.getBonus());
        System.out.printf("The salary of Manager is: %.2f (with %.2f%% bonus)\n",manager1.getSalary(),manager1.getBonus());
        sc.close();
    }
}
