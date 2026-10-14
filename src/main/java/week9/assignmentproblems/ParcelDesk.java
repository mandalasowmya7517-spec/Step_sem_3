import java.util.Scanner;

interface Parcel {
    double charge(double weight);
    double insurance(double value);
    String getType();
}

class Standard implements Parcel {
    public double charge(double weight) { return 40 + 10 * weight; }
    public double insurance(double value) { return 0; }
    public String getType() { return "STANDARD"; }
}

class Express implements Parcel {
    public double charge(double weight) { return 80 + 15 * weight; }
    public double insurance(double value) { return value * 0.02; }
    public String getType() { return "EXPRESS"; }
}

class Fragile implements Parcel {
    public double charge(double weight) { return 40 + 10 * weight + 50; }
    public double insurance(double value) { return value * 0.02; }
    public String getType() { return "FRAGILE"; }
}

public class ParcelDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            Parcel p;
            switch (type) {
                case "STANDARD": p = new Standard(); break;
                case "EXPRESS": p = new Express(); break;
                default: p = new Fragile(); break;
            }
            double c = p.charge(w);
            double ins = p.insurance(v);
            double tot = c + ins;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.getType(), c, ins, tot);
            grand += tot;
        }
        System.out.printf("Grand Total: %.2f", grand);
        sc.close();
    }
}
