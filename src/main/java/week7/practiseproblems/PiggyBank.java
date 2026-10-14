public class PiggyBank {
    private double savings;

    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Deposited: " + amount + " | Current Savings: " + savings);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= savings && amount > 0) {
            savings -= amount;
            System.out.println("Withdrew: " + amount + " | Current Savings: " + savings);
        } else {
            System.out.println("Withdrawal rejected. Current Savings: " + savings);
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);   // savings = 100
        pb.withdraw(30);   // savings = 70
        pb.withdraw(500);  // rejected, savings stays 70

        System.out.println("Final Savings in " + pb.getId() + ": " + pb.getSavings());
    }
}
