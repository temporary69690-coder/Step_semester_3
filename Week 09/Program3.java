import java.util.Scanner;

abstract class Student {
    protected String name;
    private static final double TRANSPORT_FEE = 12000;
    Student(String name) { this.name = name; }
    abstract double tuition();
    boolean usesBus() { return false; }
    double fee() { return tuition() + (usesBus() ? TRANSPORT_FEE : 0); }
}

class DayScholar extends Student {
    DayScholar(String name) { super(name); }
    @Override double tuition() { return 40000; }
    @Override boolean usesBus() { return true; }
}

class Hosteller extends Student {
    Hosteller(String name) { super(name); }
    @Override double tuition() { return 40000 + 60000; }
}

class Scholar extends Student {
    Scholar(String name) { super(name); }
    @Override double tuition() { return 40000 * 0.5; }
    @Override boolean usesBus() { return true; }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            students[i] = switch (type) {
                case "DAY_SCHOLAR" -> new DayScholar(name);
                case "HOSTELLER" -> new Hosteller(name);
                case "SCHOLAR" -> new Scholar(name);
                default -> null;
            };
        }

        for (Student s : students) {
            double f = s.fee();
            total += f;
            System.out.printf("%s: %.2f%n", s.name, f);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
