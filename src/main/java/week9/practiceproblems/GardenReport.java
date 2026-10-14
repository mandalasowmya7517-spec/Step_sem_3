import java.util.Scanner;

interface Plot {
    double area();
    String getOwner();
    String getShape();
}

class Circle implements Plot {
    private String owner; private double r;
    public Circle(String o,double r){owner=o;this.r=r;}
    public double area(){return Math.PI*r*r;}
    public String getOwner(){return owner;}
    public String getShape(){return "CIRCLE";}
}

class Rectangle implements Plot {
    private String owner; private double l,w;
    public Rectangle(String o,double l,double w){owner=o;this.l=l;this.w=w;}
    public double area(){return l*w;}
    public String getOwner(){return owner;}
    public String getShape(){return "RECTANGLE";}
}

class Triangle implements Plot {
    private String owner; private double b,h;
    public Triangle(String o,double b,double h){owner=o;this.b=b;this.h=h;}
    public double area(){return 0.5*b*h;}
    public String getOwner(){return owner;}
    public String getShape(){return "TRIANGLE";}
}

public class GardenReport {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); String owner=sc.next();
            Plot p;
            if(type.equals("CIRCLE")) p=new Circle(owner,sc.nextDouble());
            else if(type.equals("RECTANGLE")) p=new Rectangle(owner,sc.nextDouble(),sc.nextDouble());
            else p=new Triangle(owner,sc.nextDouble(),sc.nextDouble());
            double a=p.area();
            System.out.printf("%s (%s): %.2f%n",p.getOwner(),p.getShape(),a);
            total+=a;
        }
        System.out.printf("Total Area: %.2f",total);
        sc.close();
    }
}
