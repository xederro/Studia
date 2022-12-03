// Napisz program wyznaczający numerycznie sumę n wyrazów ciągu  
// o elementach: a0 = 1; a1=sin(1); a2=sin(2); .... ; an=sin(n)

#include <stdio.h>
#include <math.h>

using namespace std;

void sumaCiagu(int N) {
    double suma = 1;

    for (int i = 1; i <= N; i++) {
        suma += sin(i);
    }

    printf("%lf", suma);
}

int main() {
    int N = 0;

    printf("Wpisz N:\n");
    scanf("%d", &N);

    sumaCiagu(N);
}