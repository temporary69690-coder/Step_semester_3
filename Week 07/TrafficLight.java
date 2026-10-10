public class TrafficLight {
    private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};
    private final String id;
    private int position; // 0=RED, 1=GREEN, 2=YELLOW

    public TrafficLight(String id) {
        this.id = id;
        this.position = 0;
    }

    public String getColor() {
        return CYCLE[position];
    }

    public void next() {
        position = (position + 1) % CYCLE.length;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor(): " + t.getColor());
        t.next();
        System.out.println("t.next(): " + t.getColor());
        t.next();
        System.out.println("t.next(): " + t.getColor());
        t.next();
        System.out.println("t.next(): " + t.getColor());
    }
}