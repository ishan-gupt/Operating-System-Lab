import java.util.Scanner;

public class LAB1_3 {
    static class First extends Thread {
        int num;
       public int sumf;
        First(int n){
            this.num = n;
            sumf=0;
        }
        public void run(){
            int d=num/2;
            for(int i=1;i<=d;i++){
                sumf=sumf+i;
            }
            System.out.println("Sum from 1 to n/2 is "+sumf);
        }
        public long getId(){
            return sumf;
        }

    }
    static class Last extends Thread {
        int num;
        int suml;
        Last(int n){
            num = n;
            suml=0;
        }
        public void run(){
            int dig=(num/2)+1;
            for(int i=dig;i<=num;i++){
                suml+=i;
            }
            System.out.println("Sum from n/2+1 to n is "+suml);
        }
        public long getValue(){
            return suml;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        Thread t1=new Thread(new First(n));
        t1.start();
        Thread t2=new Thread(new Last(n));
        t2.start();
        t1.wait();
        t2.join();
        int s1= (int) t1.getId();
        int s2= (int) t2.getId();
        int total=s1+s2;
        System.out.println(total);

    }
}
