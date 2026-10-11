import java.util.Scanner;

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;
    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }
    abstract double charge();
    boolean insurable() { return false; }
    double insurance() { return insurable() ? declaredValue * 0.02 : 0; }
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super(w, v); }
    @Override double charge() { return 40 + weightKg * 10; }
}

class ExpressParcel extends Parcel {
    ExpressParcel(double w, double v) { super(w, v); }
    @Override double charge() { return 80 + weightKg * 15; }
    @Override boolean insurable() { return true; }
}

class FragileParcel extends Parcel {
    FragileParcel(double w, double v) { super(w, v); }
    @Override double charge() { return 40 + weightKg * 10 + 50; }
    @Override boolean insurable() { return true; }
}

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            parcels[i] = switch (type) {
                case "STANDARD" -> new StandardParcel(w, v);
                case "EXPRESS" -> new ExpressParcel(w, v);
                case "FRAGILE" -> new FragileParcel(w, v);
                default -> null;
            };
        }

        for (Parcel p : parcels) {
            double c = p.charge();
            double ins = p.insurance();
            double t = c + ins;
            grandTotal += t;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                p.getClass().getSimpleName().toUpperCase().replace("PARCEL", ""), c, ins, t);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
