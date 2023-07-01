// Napisz funkcję sumującą wszystkie liczby parzyste z przedziału \[-N, N \].  
// Wartość N powinna być parametrem wejściowym tej funkcji.

#include <stdio.h>

using namespace std;

void sumujParzyste(unsigned int N) {
    int suma = 0;

    if (N % 2 == 1)
    {
        N--;
    }

    for (long int i = -N; i <= (long long int)N; i += 2) {
        suma += i;
    }

    printf("%Ld", suma);
}

int main() {
    unsigned int N = 0;

    printf("Wpisz N:\n");
    scanf("%u", &N);

    sumujParzyste(N);
}