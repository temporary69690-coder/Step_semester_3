import java.util.Scanner;

abstract class Room {
    protected int units;
    Room(int units) { this.units = units; }
    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super(units); }
    @Override double bill() { return units * 8.0; }
}

class SharedRoom extends Room {
    private int occupants;
    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    @Override double bill() { return (units * 6.0) / occupants; }
}

class ACRoom extends Room {
    ACRoom(int units) { super(units); }
    @Override double bill() { return units * 10.0 + 200; }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Room[] rooms = new Room[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            switch (type) {
                case "SINGLE" -> rooms[i] = new SingleRoom(units);
                case "SHARED" -> rooms[i] = new SharedRoom(units, sc.nextInt());
                case "AC" -> rooms[i] = new ACRoom(units);
            }
        }

        for (Room r : rooms) {
            double b = r.bill();
            total += b;
            String name = r.getClass().getSimpleName().replace("Room", "").toUpperCase();
            System.out.printf("%s: %.2f%n", name, b);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
