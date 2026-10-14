import java.util.Scanner;

public class WordPalindrome {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        String rev=new StringBuilder(word).reverse().toString();
        System.out.println(word+" - "+(word.equals(rev)?"palindrome":"not a palindrome"));
        System.out.println(rev+" - "+(rev.equals(new StringBuilder(rev).reverse().toString())?"palindrome":"not a palindrome"));
        sc.close();
    }
}
