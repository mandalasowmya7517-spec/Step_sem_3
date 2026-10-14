import java.util.Scanner;

abstract class Staff {
    protected String name;
    public Staff(String n){name=n;}
    public String getName(){return name;}
    public abstract double pay();
}

class FullTime extends Staff {
    private double salary;
    public FullTime(String n,double s){super(n);salary=s;}
    public double pay(){return salary;}
}

class Hourly extends Staff {
    private double h,r;
    public Hourly(String n,double h,double r){super(n);this.h=h;this.r=r;}
    public double pay(){return h<=40?h*r:40*r+(h-40)*1.5*r;}
}

class Intern extends Staff {
    private double stipend;
    public Intern(String n,double s){super(n);stipend=s;}
    public double pay(){return stipend;}
}

public class Payroll {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); String name=sc.next();
            Staff s;
            if(type.equals("FULLTIME")) s=new FullTime(name,sc.nextDouble());
            else if(type.equals("HOURLY")) s=new Hourly(name,sc.nextDouble(),sc.nextDouble());
            else s=new Intern(name,sc.nextDouble());
            double p=s.pay();
            System.out.printf("%s: %.2f%n",s.getName(),p);
            total+=p;
        }
        System.out.printf("Total Payroll: %.2f",total);
        sc.close();
    }
}
