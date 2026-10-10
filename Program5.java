public class Program5 {

    private String empName;
    private double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Program5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        Program5 e1 = new Program5("Rahul", 50000);
        Program5 e2 = new Program5("Priya", 60000);
        Program5 e3 = new Program5("Arjun", 55000);

        Program5.printCompanyInfo();
    }
}