import java.util.Scanner;

interface Customer {
    double calculateFinalAmount(double amount);
    String getType();
}

class Student implements Customer {
    public double calculateFinalAmount(double amount) {
        return amount * 0.90;
    }
    public String getType() {
        return "STUDENT";
    }
}

class Staff implements Customer {
    public double calculateFinalAmount(double amount) {
        return amount * 0.95;
    }
    public String getType() {
        return "STAFF";
    }
}

class Guest implements Customer {
    public double calculateFinalAmount(double amount) {
        return amount + 10;
    }
    public String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Customer c;

            switch (type) {
                case "STUDENT": c = new Student(); break;
                case "STAFF": c = new Staff(); break;
                default: c = new Guest(); break;
            }

            double finalAmount = c.calculateFinalAmount(amount);
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}
