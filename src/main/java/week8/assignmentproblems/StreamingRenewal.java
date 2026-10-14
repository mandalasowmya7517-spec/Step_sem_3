import java.time.LocalDate;
import java.util.Scanner;

interface Plan {
    LocalDate getRenewalDate(LocalDate startDate);
    String getName();
}

class Basic implements Plan {
    private String name;
    public Basic(String name) {
        this.name = name;
    }
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
    public String getName() {
        return name;
    }
}

class Standard implements Plan {
    private String name;
    public Standard(String name) {
        this.name = name;
    }
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
    public String getName() {
        return name;
    }
}

class Premium implements Plan {
    private String name;
    public Premium(String name) {
        this.name = name;
    }
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
    public String getName() {
        return name;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr);
            Plan p;

            switch (type) {
                case "BASIC": p = new Basic(name); break;
                case "STANDARD": p = new Standard(name); break;
                default: p = new Premium(name); break;
            }

            LocalDate renewalDate = p.getRenewalDate(startDate);
            System.out.printf("%s: %s%n", p.getName(), renewalDate);
        }

        sc.close();
    }
}
