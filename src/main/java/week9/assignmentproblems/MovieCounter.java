import java.util.Scanner;

interface Seat {
    double price(int count);
    String getType();
}

abstract class BaseSeat implements Seat {
    protected double basePrice;
    protected static final double FEE = 20;
    public double price(int count) { return count * (basePrice + FEE); }
}

class Regular extends BaseSeat {
    public Regular() { basePrice = 150; }
    public String getType() { return "REGULAR"; }
}

class Premium extends BaseSeat {
    public Premium() { basePrice = 250; }
    public String getType() { return "PREMIUM"; }
}

class Recliner extends BaseSeat {
    public Recliner() { basePrice = 400; }
    public String getType() { return "RECLINER"; }
}

public class MovieCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Seat s;
            switch (type) {
                case "REGULAR": s = new Regular(); break;
                case "PREMIUM": s = new Premium(); break;
                default: s = new Recliner(); break;
            }
            double amt = s.price(count);
            System.out.printf("%s: %.2f%n", s.getType(), amt);
            total += amt;
        }
        System.out.printf("Total: %.2f", total);
        sc.close();
    }
}
