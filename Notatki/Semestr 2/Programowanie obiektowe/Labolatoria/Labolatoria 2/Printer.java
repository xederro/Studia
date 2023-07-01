import java.util.Scanner;

public class Printer {
    public static void print_even(int N) {
        for (int i = 0; i <= N; i+=2){
            System.out.println(i);
        }
    }

    public static void print_256(int N) {
        for (int i = 0; i <= N; i++){
            if (((i^256)&255)==0){
                System.out.printf("%h\n", i);
            }
        }
    }

    public static void print_even_bit(int N) {
        for (int i = 0; i <= N; i++){
            if ((i&1)==0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        print_even(N);

        N = scan.nextInt();
        print_even_bit(N);

        N = scan.nextInt();
        print_256(N);
    }
}
