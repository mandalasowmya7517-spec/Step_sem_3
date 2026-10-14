import java.util.Scanner;

interface Transport {
    double fare(double distance, double factor);
    String getType();
}

class Bus implements Transport {
    public double fare(double distance, double factor) {
        double result = 2 + (0.1 * distance);
        return result > 10 ? 10 : result;
    }
    public String getType() { return "BUS"; }
}

class Train implements Transport {
    public double fare(double distance, double factor) {
        return 3 + (0.15 * distance);
    }
    public String getType() { return "TRAIN"; }
}

class Metro implements Transport {
    public double fare(double distance, double factor) {
        return (1.5 + (0.2 * distance)) * factor;
    }
    public String getType() { return "METRO"; }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            double factor = 1.0;
            if (type.equals("METRO")) factor = sc.nextDouble();
            Transport t;
            switch (type) {
                case "BUS": t = new Bus(); break