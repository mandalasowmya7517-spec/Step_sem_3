import java.util.Scanner;

public class DigitSumReverse {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int sum=0,rev=0;
        while(num>0){
            int d=num%10;
            sum+=d;
            rev=rev*10+d;
            num/=10;
        }
        System.out.println("Sum of digits: "+sum);
        System.out.println("Reverse: "+rev);
        sc.close();
    }
}
