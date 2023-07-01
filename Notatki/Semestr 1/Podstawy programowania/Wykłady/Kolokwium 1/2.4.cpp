// Napisz funkcję sumującą kwadraty wszystkich liczb nieparzystych  
// z przedziału \[-**N, N \]**. Wartość **N** powinna być parametrem wejściowym tej funkcji.

#include <stdio.h>

using namespace std;

void sumujKwadratyNieparzystych(unsigned int N) {
    long long int suma = 0;

    if (N % 2 == 0)
    {
        N--;
    }

    for (long int i = -N; i <= (long long int)N; i += 2) {
        suma += (i * i);
    }

    printf("%Ld", suma);
}

int main() {
    unsigned int N = 0;

    printf("Wpisz N:\n");
    scanf("%u", &N);

    sumujKwadratyNieparzystych(N);
}