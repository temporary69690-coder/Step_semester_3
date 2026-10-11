import java.util.Scanner;

abstract class Customer {
    protected double amount;
    Customer(double amount) { this.amount = amount; }
    abstract double finalAmount();
}

class Student extends Customer {
    Student(double amount) { super(amount); }
    @Override double finalAmount() { return amount * 0.90; }
}

class Staff extends Customer {
    Staff(double amount) { super(amount); }
    @Override double finalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    Guest(double amount) { super(amount); }
    @Override double finalAmount() { return amount + 10; }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Customer[] bills = new Customer[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            switch (type) {
                case "STUDENT" -> bills[i] = new Student(amount);
                case "STAFF" -> bills[i] = new Staff(amount);
                case "GUEST" -> bills[i] = new Guest(amount);
            }
        }

        for (Customer c : bills) {
            double fa = c.finalAmount();
            total += fa;
            System.out.printf("%s: %.2f%n", c.getClass().getSimpleName().toUpperCase(), fa);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
