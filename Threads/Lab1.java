import java.util.Scanner;

public class Lab1 {
    static class Digits extends Thread {
        int n;
        Digits(int n){
            this.n = n;
        }
        public void run(){
            int sum=0;
            int digit;
            while(n > 0)
            {
                digit = n % 10;
                sum = sum + digit;
                n = n / 10;
            }
            System.out.println("Sum of digits is "+sum);
        }
    }
    static class reverse extends Thread {
        int num;
        reverse(int n){
            num = n;
        }
        public void run(){
            int r=0;
            while(num != 0)
            {
                int remainder = num % 10;
                r = r * 10 + remainder;
                num = num/10;
            }
            System.out.println("Reverse of number is "+r);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        Thread t1=new Thread(new Digits(n));
        t1.start();
        Thread t2=new Thread(new reverse(n));
        t2.start();
        }
}
