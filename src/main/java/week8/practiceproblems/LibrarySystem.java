import java.time.LocalDate;
import java.util.Scanner;

interface Item {
    LocalDate dueDate(LocalDate current);
    String getTitle();
}

class Book implements Item {
    private String title;
    public Book(String title) { this.title = title; }
    public LocalDate dueDate(LocalDate current) { return current.plusDays(14); }
    public String getTitle() { return title; }
}

class Dvd implements Item {
    private String title;
    public Dvd(String title) { this.title = title; }
    public LocalDate dueDate(LocalDate current) { return current.plusDays(7); }
    public String getTitle() { return title; }
}

class Magazine implements Item {
    private String title;
    public Magazine(String title) { this.title = title; }
    public LocalDate dueDate(LocalDate current) { return current.plusDays(3); }
    public String getTitle() { return title; }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LocalDate current = LocalDate.parse("2023-10-26");
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");
            Item item;
            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new Dvd(title); break;
                default: item = new Magazine(title); break;
            }
            LocalDate due = item.dueDate(current);
            System.out.printf("%s: %s%n", item.getTitle(), due);
        }
        sc.close();
    }
}
