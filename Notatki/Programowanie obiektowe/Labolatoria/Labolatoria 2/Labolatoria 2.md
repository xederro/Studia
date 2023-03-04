![[Lab2_lista.pdf]]

```run-java
import java.util.Scanner;


public class Printer {
	public static void print_even(int N) {
		for (int i = 0; i < N; i+=2){  
		    System.out.printf("%d\n", i);  
		}
	}

	public static void main(String[] args) {
		print_even(new Scanner(System.in).nextInt());
	}
}
```
```run-java
import java.util.Scanner;  
  
  
public class Zadanie20 {  
    public static int fibbI(int n) {  
        int a = 0;  
        int b = 1;  
        int c = 0;  
        for (int i = 0; i < n; i++) {  
            c = a + b;  
            a = b;  
            b = c;  
        }  
        return a;  
    }  
  
    public static int fibbR(int n) {  
        if (n == 0) return 0;  
        if (n == 1) return 1;  
        return fibbR(n - 1) + fibbR(n - 2);  
    }  
  
    public static void main(String[] args) {  
        System.out.println(fibbI(new Scanner(System.in).nextInt()));  
        System.out.println(fibbR(new Scanner(System.in).nextInt()));  
    }  
}
```
