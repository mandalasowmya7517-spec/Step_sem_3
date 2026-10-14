import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        int v=0,c=0;
        word=word.toLowerCase();
        for(char ch:word.toCharArray()){
            if("aeiou".indexOf(ch)>=0) v++;
            else c++;
        }
        System.out.println("Vowels: "+v);
        System.out.println("Consonants: "+c);
        sc.close();
    }
}
