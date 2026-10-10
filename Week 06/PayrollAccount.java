public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            this.basicSalary = 0;
            System.out.println("Warning: Negative salary set to 0");
        } else {
            this.basicSalary = basicSalary;
        }
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Bonus amount must be positive");
            return;
        }
        bonus += amount;
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Error: Tax percentage must be between 0 and 100");
            return;
        }
        basicSalary = basicSalary * (1 - percent / 100);
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: " + account.getNetSalary());
    }
}