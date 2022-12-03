// Napisz funkcję sprawdzającą numerycznie jakie liczby całkowite  
// z przedziału \[1,1000\] spełniają równanie:  
// $\frac{x^2}{50-x}-sin(x) \geq 0$

#include <stdio.h>
#include <math.h>

using namespace std;

void ile() {
    int suma = 0;

    for (int i = 1; i <= 1000; i++) {
        if ((i != 50) && (((i * i) / (50 - i)) - sin(i) >= 0))
        {
            suma++;
        }

    }

    printf("%d", suma);
}

int main() {
    ile();
}