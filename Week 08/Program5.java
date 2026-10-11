import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;
    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    abstract LocalDate renewalDate();
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override LocalDate renewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override LocalDate renewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override LocalDate renewalDate() { return startDate.plusDays(365); }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plan[] plans = new Plan[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());
            switch (type) {
                case "BASIC" -> plans[i] = new BasicPlan(name, startDate);
                case "STANDARD" -> plans[i] = new StandardPlan(name, startDate);
                case "PREMIUM" -> plans[i] = new PremiumPlan(name, startDate);
            }
        }

        for (Plan p : plans) {
            System.out.printf("%s: %s%n", p.name, p.renewalDate());
        }
    }
}
