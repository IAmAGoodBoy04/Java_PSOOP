/*Ankit works at ABC Company. He noticed that different roles(positions) have different salaries and bonuses.

The 1st Role is an ‘Intern’ which has 3/4th of the base salary of an Employee.

Then there is ‘Clerk’ which has ½ of base salary.

And then there are ‘Manager’ who have twice the base salary of that of an employee.

Help him write a program in Java as follows.

 

Create a class ‘Employee’ which has a method named ‘getSalary’ which returns a base salary of Rs. 10,000. It also has methods named ‘getBonus’ which returns the bonus amount for that role(initially set to Rs. 0).

 

Make 3 subclasses for different roles which inherit the ‘Employee’ class and each has functions named ‘getSalary’ and ‘getBonus’.(You can assume values for ‘getBonus’ method)

 

Display the output for all cases. Also print the total salary received by each Employee after getting the bonus.

Note : Solve using method overriding*/

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

    public void getBonus(float bonus) {
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
    public void getBonus(float bonus) {
        internbonus = bonus;
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
    public void getBonus(float bonus) {
        Clerkbonus = bonus;
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
    public void getBonus(float bonus) {
        Managerbonus = bonus;
    }
}

public class employees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Intern intern1 = new Intern();
        Clerk clerk1 = new Clerk();
        Manager manager1 = new Manager();
        System.out.println("Enter values of bonus for Intern, clerk and manager respectively:");
        intern1.getBonus(sc.nextFloat());
        clerk1.getBonus(sc.nextFloat());
        manager1.getBonus(sc.nextFloat());
        System.out.printf(
                "The values of salary(including bonus) for intern, clerk and manager respectively are: %f, %f and %f respectively",
                intern1.getSalary(), clerk1.getSalary(), manager1.getSalary());
        sc.close();
    }
}
