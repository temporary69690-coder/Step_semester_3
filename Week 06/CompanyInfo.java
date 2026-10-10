public class CompanyInfo {
    private String empName;
    private double salary;
    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    public CompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new CompanyInfo("Aisha", 50000);
        new CompanyInfo("Ravi", 45000);
        new CompanyInfo("Neha", 55000);
        
        CompanyInfo.printCompanyInfo();
    }
}