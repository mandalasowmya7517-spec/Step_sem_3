import java.util.Scanner;

abstract class Booking {
    protected int km;
    protected static final double FEE=50;
    public Booking(int k){km=k;}
    public abstract double baseFare();
    public double total(){return baseFare()+FEE;}
    public abstract String getMode();
}

class Bus extends Booking {
    public Bus(int k){super(k);}
    public double baseFare(){return km*2;}
    public String getMode(){return "BUS";}
}

class Train extends Booking {
    public Train(int k){super(k);}
    public double baseFare(){return km*1.5;}
    public String getMode(){return "TRAIN";}
}

class Flight extends Booking {
    public Flight(int k){super(k);}
    public double baseFare(){return 2500+km*4;}
    public String getMode(){return "FLIGHT";}
}

public class TravelBooking {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); int km=sc.nextInt();
            Booking b;
            if(type.equals("BUS")) b=new Bus(km);
            else if(type.equals("TRAIN")) b=new Train(km);
            else b=new Flight(km);
            double t=b.total();
            System.out.printf("%s: %.2f%n",b.getMode(),t);
            total+=t;
        }
        System.out.printf("Total: %.2f",total);
        sc.close();
    }
}
