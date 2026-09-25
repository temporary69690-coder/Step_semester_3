public class Program3 {

    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    public Program3(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Program3(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {

        Program3 permanent =
                new Program3("E-101", "Divya", 65000);

        Program3 intern =
                new Program3("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}