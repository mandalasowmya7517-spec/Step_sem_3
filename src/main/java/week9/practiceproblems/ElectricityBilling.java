import java.util.Scanner;

abstract class Connection {
    protected int units;
    public Connection(int u){units=u;}
    public abstract double bill();
    public abstract String getType();
}

class Home extends Connection {
    public Home(int u){super(u);}
    public double bill(){return units<=100?units*5:100*5+(units-100)*7;}
    public String getType(){return "HOME";}
}

class Shop extends Connection {
    public Shop(int u){super(u);}
    public double bill(){return units*8+100;}
    public String getType(){return "SHOP";}
}

class Factory extends Connection {
    public Factory(int u){super(u);}
    public double bill(){return Math.max(units*6,1000);}
    public String getType(){return "FACTORY";}
}

public class ElectricityBilling {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); int u=sc.nextInt();
            Connection c;
            if(type.equals("HOME")) c=new Home(u);
            else if(type.equals("SHOP")) c=new Shop(u);
            else c=new Factory(u);
            double b=c.bill();
            System.out.printf("%s: %.2f%n",c.getType(),b);
            total+=b;
        }
        System.out.printf("Total: %.2f",total);
        sc.close();
    }
}
