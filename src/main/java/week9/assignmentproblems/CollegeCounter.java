import java.util.Scanner;

interface Student {
    double fee();
    String getName();
}

abstract class BaseStudent implements Student {
    protected String name;
    protected static final double TUITION = 40000;
    protected static final double BUS = 12000;
    public String getName() { return name; }
}

class DayScholar extends BaseStudent {
    public DayScholar(String n) { name = n; }
    public double fee() { return TUITION + BUS; }
}

class Hosteller extends BaseStudent {
    public Hosteller(String n) { name = n; }
    public double fee() { return TUITION + 60000; }
}

class Scholar extends BaseStudent {
    public Scholar(String n) { name = n; }
    public double fee() { return 20000 + BUS; }
}

public class CollegeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s;
            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER": s = new Hosteller(name); break;
                default: s = new Scholar(name); break;
            }
            double f = s.fee();
            System.out.printf("%s: %.2f%n", s.getName(), f);
            total += f;
        }
        System.out.printf("Total Collected: %.2f", total);
        sc.close();
    }
}
