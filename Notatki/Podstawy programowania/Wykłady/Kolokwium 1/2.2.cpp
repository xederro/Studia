// Napisz funkcję sprawdzającą numerycznie ile par  
// liczb całkowitych z przedziału \[a,b\] spełnia nierówność **x2 +y2 <= 50 .  
// **Wartości **a,b** powinny być zadawane jako parametry funkcji.

#include <stdio.h>

using namespace std;

void wypiszIleSpelnia(int a, int b) {
    int ile = 0;

    for (int i = a; i <= b; i++) {
        for (int j = a; j <= b; j++) {
            if (((i * i) + (j * j)) <= 50)
            {
                ile++;
            }

        }
    }

    printf("\n%d", ile);
}

int main() {
    int a, b = 0;

    printf("Wpisz [a,b]:\n");
    scanf("%d", &a);
    scanf("%d", &b);

    wypiszIleSpelnia(a, b);
}