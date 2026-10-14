import java.util.Scanner;

interface Item {
    double fine(int days);
    String getTitle();
}

class Book implements Item {
    private String title;
    public Book(String t){title=t;}
    public double fine(int d){return d*2;}
    public String getTitle(){return title;}
}

class Dvd implements Item {
    private String title;
    public Dvd(String t){title=t;}
    public double fine(int d){return Math.min(d*5,50);}
    public String getTitle(){return title;}
}

class Magazine implements Item {
    private String title;
    public Magazine(String t){title=t;}
    public double fine(int d){return d*1;}
    public String getTitle(){return title;}
}

public class LibraryFine {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); String title=sc.next();
            int days=sc.nextInt(); Item it;
            if(type.equals("BOOK")) it=new Book(title);
            else if(type.equals("DVD")) it=new Dvd(title);
            else it=new Magazine(title);
            double f=it.fine(days);
            System.out.printf("%s: %.2f%n",it.getTitle(),f);
            total+=f;
        }
        System.out.printf("Total Fines: %.2f",total);
        sc.close();
    }
}
