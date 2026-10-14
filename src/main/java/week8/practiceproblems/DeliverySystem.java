import java.util.Scanner;

interface Delivery {
    double fee(double weight, double distance, double customs);
    String getType();
}

class Standard implements Delivery {
    public double fee(double weight, double distance, double customs) {
        return 5 + (0.5 * weight) + (0.1 * distance);
    }
    public String getType() { return "STANDARD"; }
}

class Express implements Delivery {
    public double fee(double weight, double distance, double customs) {
        return 15 + (1.0 * weight) + (0.2 * distance);
    }
    public String getType() { return "EXPRESS"; }
}

class International implements Delivery {
    public double fee(double weight, double distance, double customs) {
        return 25 + (2.0 * weight) + (0.5 * distance) + customs;
    }
    public String getType() { return "INTERNATIONAL"; }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customs = 0;
            if (type.equals("INTERNATIONAL")) customs = sc.nextDouble();
            Delivery d;
            switch (type) {
                case "STANDARD": d = new Standard(); break;
                case "EXPRESS": d = new Express(); break;
                default: d = new International(); break;
            }
            double result = d.fee(weight, distance, customs);
            System.out.printf("%s: %.2f%n", d.getType(), result);
            total += result;
        }
        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}
