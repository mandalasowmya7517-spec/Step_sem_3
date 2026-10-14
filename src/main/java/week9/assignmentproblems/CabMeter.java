import java.util.Scanner;

interface Cab {
    double fare(double km, String time);
    String getType();
}

abstract class BaseCab implements Cab {
    protected double rate;
    public double fare(double km, String time) {
        double f = km * rate;
        if (f < 100) f = 100;
        if (time.equals("NIGHT") && this instanceof NightService) f *= 1.2;
        return f;
    }
}

interface NightService {}

class Mini extends BaseCab {
    public Mini() { rate = 10; }
    public String getType() { return "MINI"; }
    public double fare(double km, String time) {
        if (time.equals("NIGHT")) return -1;
        return super.fare(km, time);
    }
}

class Sedan extends BaseCab implements NightService {
    public Sedan() { rate = 14; }
    public String getType() { return "SEDAN"; }
}

class Suv extends BaseCab implements NightService {
    public Suv() { rate = 18; }
    public String getType() { return "SUV"; }
}

public class CabMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab c;
            switch (type) {
                case "MINI": c = new Mini(); break;
                case "SEDAN": c = new Sedan(); break;
                default: c = new Suv(); break;
            }
            double f = c.fare(km, time);
            if (f == -1) System.out.printf("%s: night service not available%n", c.getType());
            else {
                System.out.printf("%s: %.2f%n", c.getType(), f);
                total += f;
            }
        }
        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}
