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
