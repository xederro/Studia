// Policz iloczyn wszystkich liczb nieparzystych  
// z domkniętego przedziału liczb całkowitych \[ pierwsza  ..  ostatnia \].  
// Wartości zmiennych pierwsza, ostatnia należy wczytać z klawiatury.

#include <stdio.h>

using namespace std;

void iloczynNieparzystych(int p, int k) {
    long long int iloczyn = 1;

    if (p % 2 == 0)
    {
        p++;
    }

    if (k % 2 == 0)
    {
        k--;
    }

    for (long int i = p; i <= k; i += 2) {
        iloczyn *= i;
    }

    printf("%Ld", iloczyn);
}

int main() {
    int p, k = 0;

    printf("Wpisz [p,k]:\n");
    scanf("%d%d", &p, &k);

    iloczynNieparzystych(p, k);
}