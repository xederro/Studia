// Napisz funkcję drukującą na ekranie kolejne **N** liczb nieparzystych  
// podzielnych przez **7**. Wartość **N** powinna być parametrem.

#include <stdio.h>

using namespace std;

void wypiszNieparzyste(int N) {
    for (int i = 0; i < N; i++) {
        printf("%d\n", 7 + (14 * i));
    }
}

int main() {
    int N = 0;

    printf("Wpisz N:\n");
    scanf("%d", &N);

    wypiszNieparzyste(N);
}