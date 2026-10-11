import java.util.Scanner;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    protected int count;
    Ticket(int count) { this.count = count; }
    abstract double price();
    double amount() { return (price() + CONVENIENCE_FEE) * count; }
}

class Regular extends Ticket {
    Regular(int count) { super(count); }
    @Override double price() { return 150; }
}

class Premium extends Ticket {
    Premium(int count) { super(count); }
    @Override double price() { return 250; }
}

class Recliner extends Ticket {
    Recliner(int count) { super(count); }
    @Override double price() { return 400; }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Ticket[] tickets = new Ticket[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            switch (type) {
                case "REGULAR" -> tickets[i] = new Regular(count);
                case "PREMIUM" -> tickets[i] = new Premium(count);
                case "RECLINER" -> tickets[i] = new Recliner(count);
            }
        }

        for (Ticket t : tickets) {
            double amt = t.amount();
            total += amt;
            System.out.printf("%s: %.2f%n", t.getClass().getSimpleName().toUpperCase(), amt);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
