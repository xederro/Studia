![Lab2_lista](/Notatki/Semestr%202/Programowanie%20obiektowe/Labolatoria/Labolatoria%202/Lab2_lista.pdf)

```run-java
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
```

```run-java
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
```

![Printer](/Notatki/Semestr%202/Programowanie%20obiektowe/Labolatoria/Labolatoria%202/Printer.java)
![Fib](/Notatki/Semestr%202/Programowanie%20obiektowe/Labolatoria/Labolatoria%202/Fib.java)