import java.util.Scanner;

interface Employee {
    double calculateBonus();
    String getName();
}

class FullTime implements Employee {
    private String name;
    private double salary;
    public FullTime(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public double calculateBonus() {
        return salary * 0.10;
    }
    public String getName() {
        return name;
    }
}

class PartTime implements Employee {
    private String name;
    private double salary;
    public PartTime(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public double calculateBonus() {
        return salary * 0.05;
    }
    public String getName() {
        return name;
    }
}

class Intern implements Employee {
    private String name;
    private double salary;
    public Intern(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public double calculateBonus() {
        return 2000;
    }
    public String getName() {
        return name;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee e;

            switch (type) {
                case "FULLTIME": e = new FullTime(name, salary); break;
                case "PARTTIME": e = new PartTime(name, salary); break;
                default: e = new Intern(name, salary); break;
            }

            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n", e.getName(), bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f", total);
        sc.close();
    }
}
