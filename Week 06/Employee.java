public class Employee {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns, chains to permanent employee constructor
    public Employee(String empId, String empName) {
        this(empId, empName, 0); // this() chains to three-arg constructor
        this.isIntern = true;
    }

    public void printProfile() {
        if (isIntern) {
            System.out.println(empId + " | " + empName + " | Rs " + salary + ".0 | Intern: true");
        } else {
            System.out.println(empId + " | " + empName + " | Rs " + salary + ".0 | Intern: false");
        }
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");
        
        permanent.printProfile();
        intern.printProfile();
    }
}