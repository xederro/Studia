import java.util.Scanner;

public class Fib {
    public static int fibbI(int n){
        int a = 0;
        int b = 1;

        for(int i = 0; i < n; i++){
            int c = a;
            a = b;
            b += c;
        }

        return a;
    }

    public static int fibbR(int n){
        if (n <= 0){
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibbR(n-1) + fibbR(n-2);
        }
    }

    public static void main(String[] args) {
//        for(byte i = 1; i <= 21; i++){
//            System.out.println(fibbI(i));
//            System.out.println(fibbR(i));
//        }


        Scanner scan = new Scanner(System.in);
        int N;

        N = scan.nextInt();
        System.out.println(fibbI(N));

        N = scan.nextInt();
        System.out.println(fibbR(N));
    }
}
