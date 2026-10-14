import java.util.Scanner;

interface Vehicle {
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10;
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        double charge = hours * 50;
        return charge < 100 ? 100 : charge;
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v;

            switch (type) {
                case "BIKE": v = new Bike(); break;
                case "CAR": v = new Car(); break;
                default: v = new Truck(); break;
            }

            double charge = v.calculateCharge(hours);
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}
