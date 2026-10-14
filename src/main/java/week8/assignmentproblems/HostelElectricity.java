import java.util.Scanner;

interface Room {
    double calculateBill();
}

class SingleRoom implements Room {
    private int units;
    public SingleRoom(int units) {
        this.units = units;
    }
    public double calculateBill() {
        return units * 8;
    }
}

class SharedRoom implements Room {
    private int units;
    private int occupants;
    public SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }
    public double calculateBill() {
        return (units * 6) / (double) occupants;
    }
}

class AcRoom implements Room {
    private int units;
    public AcRoom(int units) {
        this.units = units;
    }
    public double calculateBill() {
        return (units * 10) + 200;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            Room r;

            if (type.equals("SINGLE")) {
                int units = sc.nextInt();
                r = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occupants = sc.nextInt();
                r = new SharedRoom(units, occupants);
            } else {
                int units = sc.nextInt();
                r = new AcRoom(units);
            }

            double bill = r.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}
