import java.util.Scanner;

interface Appliance {
    double units(double hours, boolean saver);
    boolean supportsSaver();
    String getType();
}

abstract class BaseAppliance implements Appliance {
    protected double power;
    public double units(double hours, boolean saver) {
        double u = (power * hours) / 1000;
        if (saver && supportsSaver()) u *= 0.75;
        return u;
    }
}

class Fridge extends BaseAppliance {
    public Fridge() { power = 150; }
    public boolean supportsSaver() { return false; }
    public String getType() { return "FRIDGE"; }
}

class Ac extends BaseAppliance {
    public Ac() { power = 1500; }
    public boolean supportsSaver() { return true; }
    public String getType() { return "AC"; }
}

class Tv extends BaseAppliance {
    public Tv() { power = 100; }
    public boolean supportsSaver() { return false; }
    public String getType() { return "TV"; }
}

class Washer extends BaseAppliance {
    public Washer() { power = 500; }
    public boolean supportsSaver() { return true; }
    public String getType() { return "WASHER"; }
}

public class EnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double h = sc.nextDouble();
            boolean saver = false;
            if (sc.hasNext("SAVER")) { sc.next(); saver = true; }
            Appliance a;
            switch (type) {
                case "FRIDGE": a = new Fridge(); break;
                case "AC": a = new Ac(); break;
