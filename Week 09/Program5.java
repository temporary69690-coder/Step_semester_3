import java.util.Scanner;

abstract class Appliance {
    protected int hours;
    Appliance(int hours) { this.hours = hours; }
    abstract double power();
    boolean saverSupported() { return false; }
    double units(boolean saver) {
        double u = power() * hours / 1000.0;
        if (saver) u *= 0.75;
        return u;
    }
}

class Fridge extends Appliance {
    Fridge(int hours) { super(hours); }
    @Override double power() { return 150; }
}

class AC extends Appliance {
    AC(int hours) { super(hours); }
    @Override double power() { return 1500; }
    @Override boolean saverSupported() { return true; }
}

class TV extends Appliance {
    TV(int hours) { super(hours); }
    @Override double power() { return 100; }
}

class Washer extends Appliance {
    Washer(int hours) { super(hours); }
    @Override double power() { return 500; }
    @Override boolean saverSupported() { return true; }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Appliance[] apps = new Appliance[n];
        boolean[] savers = new boolean[n];
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            savers[i] = saver;
            apps[i] = switch (type) {
                case "FRIDGE" -> new Fridge(hours);
                case "AC" -> new AC(hours);
                case "TV" -> new TV(hours);
                case "WASHER" -> new Washer(hours);
                default -> null;
            };
        }

        for (int i = 0; i < n; i++) {
            if (savers[i] && !apps[i].saverSupported()) {
                System.out.printf("%s: saver mode not supported%n",
                    apps[i].getClass().getSimpleName().toUpperCase());
                continue;
            }
            double u = apps[i].units(savers[i]);
            double cost = u * 8;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                apps[i].getClass().getSimpleName().toUpperCase(), u, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
