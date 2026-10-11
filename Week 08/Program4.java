import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    abstract double bonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) { super(name, salary); }
    @Override double bonus() { return salary * 0.10; }
}

class PartTime extends Employee {
    PartTime(String name, double salary) { super(name, salary); }
    @Override double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    @Override double bonus() { return 2000; }
}

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] emps = new Employee[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            switch (type) {
                case "FULLTIME" -> emps[i] = new FullTime(name, salary);
                case "PARTTIME" -> emps[i] = new PartTime(name, salary);
                case "INTERN" -> emps[i] = new Intern(name, salary);
            }
        }

        for (Employee e : emps) {
            double b = e.bonus();
            total += b;
            System.out.printf("%s: %.2f%n", e.name, b);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
