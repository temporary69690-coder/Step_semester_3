import java.util.Scanner;

abstract class Cab {
    protected double km;
    private static final double MIN_FARE = 100;
    Cab(double km) { this.km = km; }
    abstract double rate();
    boolean nightService() { return false; }
    double fare(boolean night) {
        double f = Math.max(km * rate(), MIN_FARE);
        if (night) f *= 1.20;
        return f;
    }
}

class Mini extends Cab {
    Mini(double km) { super(km); }
    @Override double rate() { return 10; }
}

class Sedan extends Cab {
    Sedan(double km) { super(km); }
    @Override double rate() { return 14; }
    @Override boolean nightService() { return true; }
}

class SUV extends Cab {
    SUV(double km) { super(km); }
    @Override double rate() { return 18; }
    @Override boolean nightService() { return true; }
}

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] times = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            times[i] = sc.next();
            cabs[i] = switch (type) {
                case "MINI" -> new Mini(km);
                case "SEDAN" -> new Sedan(km);
                case "SUV" -> new SUV(km);
                default -> null;
            };
        }

        for (int i = 0; i < n; i++) {
            boolean night = times[i].equals("NIGHT");
            if (night && !cabs[i].nightService()) {
                System.out.printf("%s: night service not available%n",
                    cabs[i].getClass().getSimpleName().toUpperCase());
                continue;
            }
            double f = cabs[i].fare(night);
            total += f;
            System.out.printf("%s: %.2f%n", cabs[i].getClass().getSimpleName().toUpperCase(), f);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
