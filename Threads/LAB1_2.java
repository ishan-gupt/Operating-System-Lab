import java.util.Scanner;

public class LAB1_2 {
    static class Odd extends Thread {
        int arrr[];
        Odd(int arr[]){
            arrr=arr;
        }
        public void run(){
            int sumo=0;
            for (int i = 0; i < arrr.length; i++) {
                if (arrr[i] % 2 != 0) {
                    sumo += arrr[i];
                }}
            System.out.println("Sum of odd is "+sumo);

    }}
    static class Even extends Thread {
        int arrr[];
        Even(int arr[]){
            arrr=arr;
            }
        public void run(){
            int sume=0;
            for (int i = 0; i < arrr.length; i++) {
                if (arrr[i] % 2 == 0) {
                    sume += arrr[i];
                }}
            System.out.println("Sum of Even is "+sume);

    }}

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in array");
        int n = sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the array ");
        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Thread t1=new Thread(new Odd(arr));
        t1.start();
        Thread t2=new Thread(new Even(arr));
        t2.start();
    }
}
