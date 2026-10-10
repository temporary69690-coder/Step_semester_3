public class HallTicket {
    private String studentName;
    private int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    // Getter for seatNumber
    public int getSeatNumber() {
        return seatNumber;
    }

    // Getter for studentName
    public String getStudentName() {
        return studentName;
    }

    // Demonstrate reference sharing
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya; // same object, no new creation
        
        // Change through the "copy" reference
        copy.seatNumber = 45; // Since we're in the same class, we can access private members
        
        System.out.println("Priya's seatNumber (via first variable): " + priya.getSeatNumber());
        System.out.println("copy == priya: " + (copy == priya));
        
        // Create a third, separate object
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}